package com.example.moodle.repository;

import com.example.moodle.models.EventStudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventStudentRepository extends JpaRepository<EventStudentModel, Long> {
    @Query("select esm.event.dateOfPublication from EventStudentModel esm where esm.student.email = ?1")
    List<Long> getAllByStudentId(String id);
}
