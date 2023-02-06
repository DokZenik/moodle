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





    public List<RatingModelDTO> getByParam(String email, String course, LocalDate startDate, LocalDate endDate){
        System.out.println(email + " " + course + " " + startDate + " " + endDate);
        List<RatingModel> list = filterRatingByParam.getByParam(email, course, startDate, endDate);
        return list.stream().map(elem -> new RatingModelDTO(elem.getRatingStudent(), elem.getDateOfSet(), elem.getImportance())).toList();
    }

}
