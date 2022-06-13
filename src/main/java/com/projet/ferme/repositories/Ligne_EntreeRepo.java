package com.projet.ferme.repositories;

import com.projet.ferme.domain.Ligne_Entree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ligne_EntreeRepo extends JpaRepository<Ligne_Entree, Long> {
    public Ligne_Entree findLigne_EntreeById(Long id);
    void deleteById(Long id);
}
