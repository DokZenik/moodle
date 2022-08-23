package com.example.moodle.repository;

import com.example.moodle.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    @Query("SELECT  s FROM Student s WHERE s.className.name = ?1")
    public List<Student> getStudentsByClassName(String className);
}
