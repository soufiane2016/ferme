package com.projet.ferme.repositories;

import com.projet.ferme.domain.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepo extends JpaRepository<Equipe, Long> {
    public Equipe findEquipeById(Long id);
    void deleteById(Long id);
}
