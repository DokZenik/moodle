package com.example.moodle.rest;

import com.example.moodle.models.RatingModel;
import com.example.moodle.models.RatingModelDTO;
import com.example.moodle.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/student/rating")
    @PreAuthorize("hasAuthority('developers:read')")
    public List<RatingModelDTO> getRatingByParam(
            @RequestParam String email,
            @RequestParam(required = false) String course,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate){
        return ratingService.getByParam(email, course, startDate, endDate);
    }

}
