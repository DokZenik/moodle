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
        ratingRepository.save(rating);
    }

    public List<RatingModel> getByParam(String email, String subject, LocalDate startDate, LocalDate endDate){
        System.out.println(email + " " + subject + " " + startDate + " " + endDate);
        return filterRatingByParam.getByParam(email, subject, startDate, endDate);
    }

}
