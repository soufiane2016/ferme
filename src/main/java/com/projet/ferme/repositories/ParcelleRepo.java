package com.projet.ferme.repositories;

import com.projet.ferme.domain.Parcelle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelleRepo extends JpaRepository<Parcelle, Long> {
    public Parcelle findParcelleById(Long id);
    void deleteById(Long id);
}
