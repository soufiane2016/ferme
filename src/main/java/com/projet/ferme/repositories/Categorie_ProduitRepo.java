package com.projet.ferme.repositories;

import com.projet.ferme.domain.Categorie_Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categorie_ProduitRepo  extends JpaRepository<Categorie_Produit, Long> {
    public Categorie_Produit findCategorie_ProduitById(Long id);
    void deleteById(Long id);
}
