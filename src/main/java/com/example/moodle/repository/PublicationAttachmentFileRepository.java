package com.example.moodle.repository;

import com.example.moodle.models.PublicationAttachmentFileModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationAttachmentFileRepository extends CrudRepository<PublicationAttachmentFileModel, Long> {
}
