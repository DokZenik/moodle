package com.example.moodle.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_of_tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankTasksModel {
    @Id
    private String path;
}
