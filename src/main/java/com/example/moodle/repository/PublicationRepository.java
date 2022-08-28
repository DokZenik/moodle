package com.example.moodle.repository;

import com.example.moodle.models.PublicationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends CrudRepository<PublicationModel, Long> {
}
