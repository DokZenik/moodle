package com.example.moodle.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Data
@ToString
public class TeacherModel {
    @Id
    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassNameModel className;

    @Column(name = "teacher_category")
    private String teacherCategory;

    @Column(name = "start_working")
    private Date startWorking;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectModel subject;

    @Column(name = "teacher_position")
    private String teacherPosition;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private InstitutionModel institution;

    @ManyToMany
    @JoinTable(
            name = "teacher_class",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<ClassNameModel> classNameSet;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic_name")
    private String patronymicName;
}
