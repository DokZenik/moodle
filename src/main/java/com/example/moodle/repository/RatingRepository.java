package com.example.moodle.repository;

import com.example.moodle.models.RatingModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<RatingModel, Long> {
}
