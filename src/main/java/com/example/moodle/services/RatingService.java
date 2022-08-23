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
import javax.swing.text.TabExpander;
import java.time.LocalDate;
import java.util.LinkedList;
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




    public void add(Rating rating, String subject) throws AccessFailException{
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaBuilder criteriaBuilder1 = em.getCriteriaBuilder();

        CriteriaQuery<Teacher> criteriaQuery = criteriaBuilder.createQuery(Teacher.class);
        CriteriaQuery<Student> studentCriteriaQuery = criteriaBuilder1.createQuery(Student.class);

        Root<Teacher> teacherRoot = criteriaQuery.from(Teacher.class);
        Root<Student> studentRoot = studentCriteriaQuery.from(Student.class);


        Predicate finalPredicate = criteriaBuilder.equal(teacherRoot.get(Teacher_.email), rating.getTeacher().getEmail());
        criteriaQuery.select(teacherRoot).where(finalPredicate);
        Teacher teacher = em.createQuery(criteriaQuery).getResultList().get(0);

        Predicate finalStudentPredicate = criteriaBuilder1.equal(studentRoot.get(Student_.email), rating.getStudent().getEmail());
        studentCriteriaQuery.select(studentRoot).where(finalStudentPredicate);
        Student student = em.createQuery(studentCriteriaQuery).getResultList().get(0);

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

    public List<Rating> getByParam(String email, String subject, LocalDate startDate, LocalDate endDate){
        System.out.println(email + " " + subject + " " + startDate + " " + endDate);
        return filterRatingByParam.getByParam(email, subject, startDate, endDate);
    }

}
