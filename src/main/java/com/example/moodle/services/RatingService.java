package com.example.moodle.services;

import com.example.moodle.exceptions.AccessFailException;
import com.example.moodle.models.*;
import com.example.moodle.repository.FilterRatingByParam;
import com.example.moodle.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final FilterRatingByParam filterRatingByParam;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public RatingService(RatingRepository ratingRepository, FilterRatingByParam filterRatingByParam) {
        this.ratingRepository = ratingRepository;
        this.filterRatingByParam = filterRatingByParam;
    }




    public void add(RatingModel rating, String subject) throws AccessFailException{
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaBuilder criteriaBuilder1 = em.getCriteriaBuilder();

        CriteriaQuery<TeacherModel> criteriaQuery = criteriaBuilder.createQuery(TeacherModel.class);
        CriteriaQuery<StudentModel> studentCriteriaQuery = criteriaBuilder1.createQuery(StudentModel.class);

        Root<TeacherModel> teacherRoot = criteriaQuery.from(TeacherModel.class);
        Root<StudentModel> studentRoot = studentCriteriaQuery.from(StudentModel.class);


        Predicate finalPredicate = criteriaBuilder.equal(teacherRoot.get(TeacherModel_.email), rating.getTeacher().getEmail());
        criteriaQuery.select(teacherRoot).where(finalPredicate);
        TeacherModel teacher = em.createQuery(criteriaQuery).getResultList().get(0);

        Predicate finalStudentPredicate = criteriaBuilder1.equal(studentRoot.get(StudentModel_.email), rating.getStudent().getEmail());
        studentCriteriaQuery.select(studentRoot).where(finalStudentPredicate);
        StudentModel student = em.createQuery(studentCriteriaQuery).getResultList().get(0);

        if(
                teacher != null && student != null &&
                        teacher.getClassNameSet().stream().anyMatch(c -> student.getClassName().getName().equals(c.getName())) &&
                        teacher.getSubject().getNameOfSubject().equals(subject)
        ) {
            rating.setSubject(teacher.getSubject());
            ratingRepository.save(rating);
        }else{
            throw new AccessFailException();
        }
    }

    public List<RatingModel> getByParam(String email, String subject, LocalDate startDate, LocalDate endDate){
        System.out.println(email + " " + subject + " " + startDate + " " + endDate);
        return filterRatingByParam.getByParam(email, subject, startDate, endDate);
    }

}
