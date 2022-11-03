package com.example.moodle.rest;

import com.example.moodle.models.StudentModel;
import com.example.moodle.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/class")
    @PreAuthorize("hasAuthority('developers:read')")
    public List<StudentModel> getByClass(@RequestParam String className){
        return studentService.getByClass(className);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<List<StudentModel>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAll());
    }
}
