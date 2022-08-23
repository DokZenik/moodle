package com.example.moodle.repository;

import com.example.moodle.models.ClassName;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<ClassName, Long> {
}
