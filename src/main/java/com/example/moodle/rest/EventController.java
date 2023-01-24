package com.example.moodle.rest;

import com.example.moodle.models.EventDTO;
import com.example.moodle.repository.EventRepository;
import com.example.moodle.services.EventStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventStudentService eventStudentService;
    @GetMapping("/test")
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<List<EventDTO>> getAllEvents(@RequestParam Long course, @RequestParam String email){
        return ResponseEntity.ok(eventStudentService.returnAllPublication(course, email));
    }
}
