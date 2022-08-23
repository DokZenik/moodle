package com.example.moodle.models;

import com.example.moodle.keys.TimetableModelKey;
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
    private Teacher teacher;

    @Id
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassName className;

    @Id
    @Column(name = "day_of_weak")
    private Long dayOfWeak;

    @Id
    @Column(name = "lesson_number")
    private Long lessonNumber;

    @Column(name = "type_of_weak")
    private Boolean flag;

}
