package com.projet.ferme.repositories;

import com.projet.ferme.domain.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo extends JpaRepository<Fournisseur, Long> {
    public Fournisseur findFournisseurById(Long id);
    void deleteById(long id);
}
