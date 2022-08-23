package com.example.moodle.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Data
@ToString
public class Teacher {
    @Id
    @Column
    private String email;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassName className;

    @Column(name = "teacher_category")
    private String teacherCategory;

    @Column(name = "start_working")
    private Date startWorking;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "teacher_position")
    private String teacherPosition;

    @ManyToMany
    @JoinTable(
            name = "teacher_class",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<ClassName> classNameSet;

}
