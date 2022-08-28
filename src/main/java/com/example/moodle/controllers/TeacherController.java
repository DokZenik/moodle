package com.example.moodle.controllers;

import com.example.moodle.models.ClassNameModel;
import com.example.moodle.models.TeacherModel;
import com.example.moodle.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> add(@RequestBody TeacherModel teacher){
        Pattern pattern = Pattern.compile("^\\w+([.\\w]+)*\\w@\\w((.\\w)*\\w+)*\\.\\w{2,3}$");
        Matcher matcher = pattern.matcher(teacher.getEmail());
        if(!matcher.matches())
            return ResponseEntity.status(400).body("Incorrect email");
        try {
            teacherService.add(teacher);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("!!!FAIL!!!") ;
        }
        return ResponseEntity.status(201).body("OK");
    }

    @GetMapping("/get")
    public TeacherModel getTeacher(@RequestParam String email){
        return teacherService.getOneTeacher(email);
    }

    @GetMapping("/getMyClasses")
    public Set<ClassNameModel> getMyStudents(@RequestParam String email){
        return teacherService.getClassesByEmail(email);
    }
}
