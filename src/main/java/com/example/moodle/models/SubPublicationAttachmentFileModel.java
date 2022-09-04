package com.example.moodle.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "file_attach_sub_publications")
@Data
public class SubPublicationAttachmentFileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "sub_publication_id")
    private SubPublicationModel subPublication;
}
