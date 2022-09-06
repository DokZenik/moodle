package com.example.moodle.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rating")
@Data
@ToString
public class RatingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentModel student;

    @Column(name = "rating_point")
    private Integer ratingStudent;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    @Column(name = "date_of_set")
    private Date dateOfSet;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherModel teacher;

    @Column
    private Float importance;

    @ManyToOne
    @JoinColumn(name = "graduation_id")
    private GraduationModel graduation;
}
