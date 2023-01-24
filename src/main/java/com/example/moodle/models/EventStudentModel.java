package com.example.moodle.models;

import javax.persistence.*;

@Entity
@Table(name = "event_student")
public class EventStudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventModel event;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentModel student;
}
