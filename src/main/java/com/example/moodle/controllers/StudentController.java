package com.example.moodle.controllers;

import com.example.moodle.models.Rating;
import com.example.moodle.models.Student;
import com.example.moodle.services.RatingService;
import com.example.moodle.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody Student student){
        Pattern pattern = Pattern.compile("^\\w+([.\\w]+)*\\w@\\w((.\\w)*\\w+)*\\.\\w{2,3}$");
        Matcher matcher = pattern.matcher(student.getEmail());
        if(!matcher.matches())
            return ResponseEntity.status(400).body("Incorrect email");
        try {
            studentService.add(student);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("!!!FAIL!!!") ;
        }
        return ResponseEntity.ok("OK");
    }



    @GetMapping("/class")
    public List<Student> getByClass(@RequestParam String className){
        return studentService.getByClass(className);
    }

}
