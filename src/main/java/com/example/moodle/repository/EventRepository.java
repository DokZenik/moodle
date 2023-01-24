package com.example.moodle.repository;

import com.example.moodle.models.EventDTO;
import com.example.moodle.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Date;

public interface EventRepository extends JpaRepository<EventModel, Long> {
    @Query("select new com.example.moodle.models.EventDTO(e.title, e.body, e.dateOfPublication, e.typeOfTask, false, e.deadline) from EventModel e WHERE e.course.id = ?1")
    List<EventDTO> getAllByCourse(Long id);
}
