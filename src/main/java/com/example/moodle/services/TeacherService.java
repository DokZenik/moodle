package com.example.moodle.services;

import com.example.moodle.models.ClassName;
import com.example.moodle.models.Student;
import com.example.moodle.models.Teacher;
import com.example.moodle.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public void add(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public List<Teacher> getAll(){
        List<Teacher> list = new ArrayList<>();
        teacherRepository.findAll().forEach(list::add);
        return list;
    }

    public Teacher getOneTeacher(String email){
        return teacherRepository.getTeacherByEmail(email);
    }
    public Set<ClassName> getClassesByEmail(String email){
        return teacherRepository.getTeacherByEmail(email).getClassNameSet();
    }
}
