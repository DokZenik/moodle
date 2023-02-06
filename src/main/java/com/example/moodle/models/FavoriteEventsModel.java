package com.example.moodle.models;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "favorite_events")
public class FavoriteEventsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private String event;

    @Column(name = "student_id")
    private String student;

}
