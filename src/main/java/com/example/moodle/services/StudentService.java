package com.example.moodle.services;

import com.example.moodle.models.StudentModel;
import com.example.moodle.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public StudentModel findByEmail(String email){
        return studentRepository.findByEmail(email);
    }
    public List<StudentModel> getAll(){
        List<StudentModel> list = new ArrayList<>();
        studentRepository.findAll().forEach(list::add);
        return list;
    }
}
