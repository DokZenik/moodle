package com.example.moodle.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "institution")
@Data
public class InstitutionModel {
    @Id
    private Long id;
    private String name;
}
