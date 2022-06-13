package com.projet.ferme.repositories;

import com.projet.ferme.domain.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageRepo extends JpaRepository<Voyage, Long> {
    public Voyage findVoyageById(Long id);
    void deleteById(Long id);
}
