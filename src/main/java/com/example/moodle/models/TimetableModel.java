package com.example.moodle.models;

import com.example.moodle.repository.keys.TimetableModelKey;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
@IdClass(TimetableModelKey.class)
@Data
@ToString
public class TimetableModel {

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherModel teacher;

    @Id
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassNameModel className;

    @Id
    @Column(name = "day_of_weak")
    private Integer dayOfWeak;

    @Id
    @Column(name = "lesson_number")
    private Integer lessonNumber;

    @Column(name = "type_of_weak")
    private Boolean flag;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private InstitutionModel institution;

}
