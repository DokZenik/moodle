package com.example.moodle.services;

import com.example.moodle.models.TimetableModel;
import com.example.moodle.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    private final TimetableRepository timetableRepository;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public void add(TimetableModel timetableModel){
        timetableRepository.save(timetableModel);
    }
    public List<TimetableModel> get(String className){
        return timetableRepository.get(className);
    }
}
