package com.example.moodle.rest;

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

    @GetMapping("/get")
    public TeacherModel getTeacher(@RequestParam String email){
        return teacherService.getOneTeacher(email);
    }

    @GetMapping("/getMyClasses")
    public Set<ClassNameModel> getMyStudents(@RequestParam String email){
        return teacherService.getClassesByEmail(email);
    }
}
