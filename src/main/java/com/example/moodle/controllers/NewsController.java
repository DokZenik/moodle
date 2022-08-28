package com.example.moodle.controllers;

import com.example.moodle.models.NewsModel;
import com.example.moodle.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody NewsModel news){
        newsService.add(news);
        return ResponseEntity.ok().build();
    }
}
