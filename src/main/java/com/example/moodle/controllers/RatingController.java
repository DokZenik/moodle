package com.example.moodle.controllers;

import com.example.moodle.models.Rating;
import com.example.moodle.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Rating> getRatingByParam(
            @RequestParam String email,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate){
        return ratingService.getByParam(email, subject, startDate, endDate);
    }

    @PostMapping("/teacher/evaluate")
    public ResponseEntity<String> setRating(@RequestBody Rating rating, @RequestParam String subject){
        try {
            ratingService.add(rating, subject);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("!!!FAIL!!!") ;
        }
        return ResponseEntity.ok("OK");
    }
}
