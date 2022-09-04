package com.example.moodle.services;

import com.example.moodle.models.PublicationAttachmentFileModel;
import com.example.moodle.models.SubPublicationAttachmentFileModel;
import com.example.moodle.repository.PublicationAttachmentFileRepository;
import com.example.moodle.repository.SubPublicationAttachmentFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {
    private final SubPublicationAttachmentFileRepository subPublicationAttachmentFileRepository;
    private final PublicationAttachmentFileRepository publicationAttachmentFileRepository;

    public void addPubFile(PublicationAttachmentFileModel file){
        publicationAttachmentFileRepository.save(file);
    }
    public void addSubPubFile(SubPublicationAttachmentFileModel file){
        subPublicationAttachmentFileRepository.save(file);
    }
}
