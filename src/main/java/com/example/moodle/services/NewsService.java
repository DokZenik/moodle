package com.example.moodle.services;

import com.example.moodle.models.NewsModel;
import com.example.moodle.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public void add(NewsModel news){
        newsRepository.save(news);
    }
}
