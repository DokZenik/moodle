package com.example.moodle.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sub_publication")
@Data
public class SubPublicationModel {
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "publication_id")
    private PublicationModel publication;

}
