package com.example.moodle.repository;

import com.example.moodle.models.RatingModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Repository
public class FilterRatingByParam {
    @PersistenceContext
    private EntityManager em;

    public List<RatingModel> getByParam(String email, String subject, LocalDate startDate, LocalDate endDate){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<RatingModel> criteriaQuery = criteriaBuilder.createQuery(RatingModel.class);
        Root<RatingModel> ratingRoot = criteriaQuery.from(RatingModel.class);

        List<Predicate> predicateList = new LinkedList<>();

        if(email != null){
            predicateList.add(criteriaBuilder.equal(ratingRoot.get("student").get("email"), email));
        }

        if(subject != null){
            predicateList.add(criteriaBuilder.equal(ratingRoot.get("subject").get("nameOfSubject"), subject));
        }

        if(startDate != null){
            predicateList.add(criteriaBuilder.greaterThanOrEqualTo(ratingRoot.get("dateOfSet"), Date.valueOf(startDate)));
        }

        if(endDate != null){
            predicateList.add(criteriaBuilder.lessThanOrEqualTo(ratingRoot.get("dateOfSet"), Date.valueOf(endDate)));
        }


        Predicate finalPredicate = criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        criteriaQuery.select(ratingRoot). where(finalPredicate);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
