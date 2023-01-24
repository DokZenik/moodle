package com.example.moodle.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventDTO {
    private String title;
    private String body;
    private Long dateOfPublication;
    private TypeOfTask typeOfPublication;
    private Boolean isDone;
}
