package com.example.moodle.services;

import com.example.moodle.models.EventDTO;
import com.example.moodle.repository.EventRepository;
import com.example.moodle.repository.EventStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventStudentService {
    private final EventStudentRepository eventStudentRepository;
    private final EventRepository eventRepository;
    public List<EventDTO> returnAllPublication(Long course, String email){
        List<Long> allByStudentId = eventStudentRepository.getAllByStudentId(email);
        allByStudentId.add(123456L);
        allByStudentId.forEach(System.out::println);

        return eventRepository.getAllByCourse(course).stream().map(elem -> {
            if(allByStudentId.contains(elem.getDateOfPublication()))
                elem.setIsDone(true);
            return elem;
        }).toList();
    }
}
