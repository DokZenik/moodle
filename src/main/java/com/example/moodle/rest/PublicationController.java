package com.example.moodle.rest;

import com.example.moodle.models.PublicationModel;
import com.example.moodle.services.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publication")
@RequiredArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody PublicationModel publication){
        publicationService.add(publication);
        return ResponseEntity.ok().build();
    }


}
