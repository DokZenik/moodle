package com.example.moodle.services;

import com.example.moodle.models.ClassNameModel;
import com.example.moodle.models.TeacherModel;
import com.example.moodle.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void add(TeacherModel teacher){
        teacherRepository.save(teacher);
    }
    public List<TeacherModel> getAll(){
        List<TeacherModel> list = new ArrayList<>();
        teacherRepository.findAll().forEach(list::add);
        return list;
    }

    public TeacherModel getOneTeacher(String email){
        return teacherRepository.getTeacherByEmail(email);
    }
    public Set<ClassNameModel> getClassesByEmail(String email){
        return teacherRepository.getTeacherByEmail(email).getClassNameSet();
    }
}
