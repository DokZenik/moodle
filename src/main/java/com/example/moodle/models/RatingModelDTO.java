package com.example.moodle.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RatingModelDTO {
    private Integer rating;
    private Date date;
    private Float importance;
}
