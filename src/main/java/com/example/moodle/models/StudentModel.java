package com.example.moodle.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "student")
@Data
@ToString
public class StudentModel {
    @Id
    @Column
    private String email;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassNameModel className;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private InstitutionModel institution;
}
