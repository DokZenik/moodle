package com.example.moodle.repository;

import com.example.moodle.models.NewsModel;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<NewsModel, Long> {
}
