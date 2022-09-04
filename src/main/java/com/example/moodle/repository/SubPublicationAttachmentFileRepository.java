package com.example.moodle.repository;

import com.example.moodle.models.SubPublicationAttachmentFileModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubPublicationAttachmentFileRepository extends CrudRepository<SubPublicationAttachmentFileModel, Long> {
}
