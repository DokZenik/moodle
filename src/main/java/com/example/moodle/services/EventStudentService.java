package com.example.moodle.services;

import com.example.moodle.models.EventDTO;
import com.example.moodle.repository.EventRepository;
import com.example.moodle.repository.EventStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventStudentService {
    private final EventStudentRepository eventStudentRepository;
    private final EventRepository eventRepository;
    public List<EventDTO> returnAllPublication(Long course, String email){
        List<String> allByStudentId = eventStudentRepository.getAllByStudentId(email);

        List<EventDTO> eventDTOS = eventRepository.getAllByCourse(course).stream().map(elem -> {
            if (allByStudentId.contains(elem.getDateOfPublication()))
                elem.setIsDone(true);
            return elem;
        }).peek(
                elem ->
                        elem.setDateOfPublication(
                                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                                        .format(
                                                new Date(Long.parseLong(elem.getDateOfPublication()))
                                        ))
        ).toList();
        return eventDTOS;
    }
}
