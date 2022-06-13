package com.projet.ferme.repositories;

import com.projet.ferme.domain.Serre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerreRepo extends JpaRepository<Serre, Long> {
    public Serre findSerreById(Long id);
    void deleteById(Long id);
}
