package com.example.moodle.repository;

import com.example.moodle.models.FavoriteEventsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FavoriteEventsRepository extends JpaRepository<FavoriteEventsModel, Long> {
    @Query("select fem.event from FavoriteEventsModel fem where fem.student = ?1")
    List<String> getAllEventsByStudent(String email);
}
