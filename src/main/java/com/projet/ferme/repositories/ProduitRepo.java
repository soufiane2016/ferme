package com.projet.ferme.repositories;

import com.projet.ferme.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit, Long> {
    public Produit findProduitById(Long id);
    void deleteById(Long id);
}
