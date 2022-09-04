package com.example.moodle.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "publication")
@Data
public class PublicationModel {
    @Column
    private String title;

    @Column
    private String content;

    @Id
    @Column(name = "timestamp")
    private Long dateOfPublication;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    @Column
    private Boolean modified;

    @Column
    private Boolean visible;
}
