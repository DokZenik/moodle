package com.example.moodle.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rating")
@Data
@ToString
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_email")
    private Student student;

    @Column(name = "rating_point")
    private int ratingStudent;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "date_of_set")
    private Date dateOfSet;

    @ManyToOne
    @JoinColumn(name = "teacher_email")
    private Teacher teacher;

}
