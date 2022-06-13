package com.projet.ferme.repositories;

import com.projet.ferme.domain.Ferme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FermeRepo extends JpaRepository<Ferme, Long> {
    public Ferme findFermeById(Long id);
    void deleteById(Long id);
}
