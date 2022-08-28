package com.example.moodle.repository;

import com.example.moodle.models.TeacherModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherModel, String> {
    public TeacherModel getTeacherByEmail(String email);
}
