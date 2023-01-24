package com.example.moodle.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "event")
@Data
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String body;
    @Column(name = "date_of_publication")
    private Long dateOfPublication;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_publication")
    private TypeOfTask typeOfTask;
}
