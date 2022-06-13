package com.projet.ferme.mapper;

import com.projet.ferme.domain.Categorie_Produit;
import com.projet.ferme.dto.Categorie_ProduitDto;
import org.springframework.stereotype.Service;

@Service
public class Categorie_ProduitMapper {

    public Categorie_Produit CategorieFromDto(Categorie_ProduitDto categorie_produitDto) {
        Categorie_Produit categorie_produit = new Categorie_Produit();
        categorie_produit.setId(categorie_produitDto.getId());
        categorie_produit.setNom_categorie(categorie_produitDto.getNom_categorie());
        return categorie_produit;
    }

    public Categorie_ProduitDto DtoFromCategorie(Categorie_Produit categorie_produit) {
        Categorie_ProduitDto categorie_produitDto = new Categorie_ProduitDto();
        categorie_produitDto.setId(categorie_produit.getId());
        categorie_produitDto.setNom_categorie(categorie_produit.getNom_categorie());
        return categorie_produitDto;
    }
}
