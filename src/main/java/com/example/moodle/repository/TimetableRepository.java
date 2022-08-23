package com.example.moodle.repository;

import com.example.moodle.keys.TimetableModelKey;
import com.example.moodle.models.TimetableModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TimetableRepository extends CrudRepository<TimetableModel, TimetableModelKey> {
    @Query("SELECT t FROM TimetableModel t WHERE t.className.name = ?1")
    public List<TimetableModel> get(String className);
}
