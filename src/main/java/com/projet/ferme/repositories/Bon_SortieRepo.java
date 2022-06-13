package com.projet.ferme.repositories;

import com.projet.ferme.domain.Bon_Sortie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bon_SortieRepo extends JpaRepository<Bon_Sortie, Long> {
    public Bon_Sortie findBon_SortieById(Long id);
    void deleteById(Long id);
}
