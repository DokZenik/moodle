package com.example.moodle.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "publication")
@Data
public class PublicationModel {

    @Column
    private String content;

    @Id
    @Column(name = "timestamp")
    private Long dateOfPublication;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassNameModel className;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectModel subject;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private InstitutionModel institution;

    @Column
    private Boolean modified;
}
