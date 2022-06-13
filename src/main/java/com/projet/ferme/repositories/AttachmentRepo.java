package com.projet.ferme.repositories;

import com.projet.ferme.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepo extends JpaRepository<Attachment, Long> {
    public Attachment findAttachmentById(Long id);
    void deleteById(Long id);
}
