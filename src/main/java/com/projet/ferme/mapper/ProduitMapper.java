package com.projet.ferme.mapper;

import com.projet.ferme.domain.Categorie_Produit;
import com.projet.ferme.domain.Produit;
import com.projet.ferme.dto.ProduitDto;
import com.projet.ferme.repositories.Categorie_ProduitRepo;
import org.springframework.stereotype.Service;

@Service
public class ProduitMapper {

    private Categorie_ProduitRepo categorieProduitRepo;

    public ProduitMapper(Categorie_ProduitRepo categorieProduitRepo) {
        this.categorieProduitRepo = categorieProduitRepo;
    }

    public Produit ProduitFromDto(ProduitDto produitDto){
        Produit produit = new Produit();
        produit.setId(produitDto.getId());
        produit.setNom_produit(produitDto.getNom_produit());
        produit.setQuantite_disponible(produitDto.getQuantite_disponible());
        produit.setDate_exp(produitDto.getDate_exp());
        Categorie_Produit categorie = categorieProduitRepo.findCategorie_ProduitById(produitDto.getCategorie_produitId());
        produit.setCategorie_produit(categorie);
        return produit;
    }

    public ProduitDto DtoFromProduit(Produit produit) {
        ProduitDto produitDto = new ProduitDto();
        produitDto.setId(produit.getId());
        produitDto.setNom_produit(produit.getNom_produit());
        produitDto.setQuantite_disponible(produit.getQuantite_disponible());
        produitDto.setDate_exp(produit.getDate_exp());
        produitDto.setCategorie_produitId(produit.getCategorie_produit().getId());
        return produitDto;
    }
}
