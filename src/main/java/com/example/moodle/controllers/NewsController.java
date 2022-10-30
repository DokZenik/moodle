package com.example.moodle.controllers;

import com.example.moodle.models.NewsModel;
import com.example.moodle.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAll")
    public ResponseEntity<List<NewsModel>> getAllNews(){
        return ResponseEntity.ok(newsService.getAllNews());
    }
}
