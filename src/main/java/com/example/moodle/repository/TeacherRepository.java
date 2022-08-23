package com.example.moodle.repository;

import com.example.moodle.models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, String> {
    public Teacher getTeacherByEmail(String email);
}
