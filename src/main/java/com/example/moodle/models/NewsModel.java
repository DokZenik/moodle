package com.example.moodle.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Data
public class NewsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column(name = "date_of_publication")
    private Long dateOfPublication;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private InstitutionModel institution;
}
