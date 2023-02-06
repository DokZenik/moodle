package com.example.moodle.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EventDTO {
    private String titleOfPublication;
    private String bodyOfPublication;
    private String dateOfPublication;
    private TypeOfTask typeOfPublication;
    private Boolean isDone;
    private Date deadline;
}
