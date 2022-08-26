package com.projet.ferme.repositories;

import com.projet.ferme.domain.Bon_Entree;
import com.projet.ferme.domain.Ligne_Entree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Bon_EntreeRepo extends JpaRepository<Bon_Entree,Long> {
    public Bon_Entree findBon_EntreeById(Long id);
    void deleteById(Long id);
}
