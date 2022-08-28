package com.example.moodle.services;

import com.example.moodle.models.StudentModel;
import com.example.moodle.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void add(StudentModel student){
        studentRepository.save(student);
    }

    public List<StudentModel> getByClass(String className){
        return studentRepository.getStudentsByClassName(className);
    }
}
