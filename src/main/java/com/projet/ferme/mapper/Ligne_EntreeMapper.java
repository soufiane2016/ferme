package com.projet.ferme.mapper;

import com.projet.ferme.domain.Bon_Entree;
import com.projet.ferme.domain.Ligne_Entree;
import com.projet.ferme.domain.Produit;
import com.projet.ferme.dto.Ligne_EntreeDto;
import com.projet.ferme.repositories.Bon_EntreeRepo;
import com.projet.ferme.repositories.Ligne_EntreeRepo;
import com.projet.ferme.repositories.ProduitRepo;
import org.springframework.stereotype.Service;

@Service
public class Ligne_EntreeMapper {
    private Bon_EntreeRepo bonEntreeRepo;
    private ProduitRepo produitRepo;

    public Ligne_EntreeMapper(Bon_EntreeRepo bonEntreeRepo, ProduitRepo produitRepo) {
        this.bonEntreeRepo = bonEntreeRepo;
        this.produitRepo = produitRepo;
    }

    public Ligne_Entree Ligne_EntreeFromDto(Ligne_EntreeDto ligneEntreeDto) {
        Ligne_Entree ligneEntree = new Ligne_Entree();
        ligneEntree.setId(ligneEntreeDto.getId());
        ligneEntree.setPrix(ligneEntreeDto.getPrix());
        ligneEntree.setQuantite(ligneEntreeDto.getQuantite());
        ligneEntree.setUnite(ligneEntreeDto.getUnite());
        Bon_Entree bonEntree = bonEntreeRepo.findBon_EntreeById(ligneEntreeDto.getBonEntreeId());
        Produit produit = produitRepo.findProduitById(ligneEntreeDto.getProduitId());
        ligneEntree.setBon_entree(bonEntree);
        ligneEntree.setProduit(produit);
        return ligneEntree;
    }

    public Ligne_EntreeDto DtoFromLigne_Entree(Ligne_Entree ligneEntree) {
        Ligne_EntreeDto ligneEntreeDto = new Ligne_EntreeDto();
        ligneEntreeDto.setId(ligneEntree.getId());
        ligneEntreeDto.setPrix(ligneEntree.getPrix());
        ligneEntreeDto.setQuantite(ligneEntree.getQuantite());
        ligneEntreeDto.setUnite(ligneEntree.getUnite());
        ligneEntreeDto.setBonEntreeId(ligneEntree.getBon_entree().getId());
        ligneEntreeDto.setProduitId(ligneEntree.getProduit().getId());
        ligneEntreeDto.setNom_produit(ligneEntree.getProduit().getNom_produit());
        return ligneEntreeDto;
    }
}
