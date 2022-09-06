package com.example.moodle.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "graduation")
@Data
public class GraduationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}
