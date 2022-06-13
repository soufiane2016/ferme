package com.projet.ferme.repositories;

import com.projet.ferme.domain.Ligne_Sortie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ligne_SortieRepo extends JpaRepository<Ligne_Sortie, Long> {
    public Ligne_Sortie findLigne_SortieById(Long id);
    void deleteById(Long id);
}
