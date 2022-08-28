package com.example.moodle.repository;

import com.example.moodle.models.ClassNameModel;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<ClassNameModel, Long> {
}
