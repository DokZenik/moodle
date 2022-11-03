package com.example.moodle.repository;

import com.example.moodle.models.StudentModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, String> {
    @Query("SELECT  s FROM StudentModel s WHERE s.className.name = ?1")
    public List<StudentModel> getStudentsByClassName(String className);
    StudentModel findByEmail(String email);
}
