package com.projet.ferme.repositories;

import com.projet.ferme.domain.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChauffeurRepo extends JpaRepository<Chauffeur, Long> {
    public Chauffeur findChauffeurById(Long id);
    void deleteById(Long id);
}
