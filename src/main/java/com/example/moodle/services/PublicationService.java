package com.example.moodle.services;

import com.example.moodle.models.PublicationModel;
import com.example.moodle.repository.PublicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;

    public void add(PublicationModel publication){
        publicationRepository.save(publication);
    }
}
