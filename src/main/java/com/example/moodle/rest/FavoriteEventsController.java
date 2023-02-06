package com.example.moodle.rest;

import com.example.moodle.repository.FavoriteEventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class FavoriteEventsController {
    private final FavoriteEventsRepository favoriteEventsRepository;
    @GetMapping("/getAllFavorites/{email}")
    public List<String> getAllFavoritesEventsByStudent(@PathVariable String email){
        return favoriteEventsRepository.getAllEventsByStudent(email);
    }
}
