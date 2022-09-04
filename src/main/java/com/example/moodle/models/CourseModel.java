package com.example.moodle.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Data
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectModel subject;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassNameModel className;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherModel teacher;
}
