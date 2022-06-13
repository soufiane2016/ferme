package com.projet.ferme.services;

import com.projet.ferme.domain.Categorie_Produit;
import com.projet.ferme.dto.Categorie_ProduitDto;
import com.projet.ferme.mapper.Categorie_ProduitMapper;
import com.projet.ferme.repositories.Categorie_ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieProduitService {
    private Categorie_ProduitRepo categorieProduitRepo;
    private Categorie_ProduitMapper categorieProduitMapper;

    @Autowired
    public CategorieProduitService(Categorie_ProduitRepo categorieProduitRepo, Categorie_ProduitMapper categorieProduitMapper) {
        this.categorieProduitRepo = categorieProduitRepo;
        this.categorieProduitMapper = categorieProduitMapper;
    }

    public Categorie_Produit addProduit(Categorie_ProduitDto categorieProduitDto){
        Categorie_Produit categorieProduit = categorieProduitMapper.CategorieFromDto(categorieProduitDto);
        return categorieProduitRepo.save(categorieProduit);
    }

    public Categorie_Produit updateProduit(Categorie_ProduitDto categorieProduitDto){
        Categorie_Produit updateProduit = categorieProduitMapper.CategorieFromDto(categorieProduitDto);
        return categorieProduitRepo.save(updateProduit);
    }

    public List<Categorie_ProduitDto> getAllProduit(){
        List<Categorie_Produit> listProduits =  categorieProduitRepo.findAll();
        List<Categorie_ProduitDto> produitDtoList = new ArrayList<>();
        listProduits.forEach(produit -> produitDtoList.add(categorieProduitMapper.DtoFromCategorie(produit)));
        return produitDtoList;
    }
    public Categorie_Produit getProduitbyId(Long id){
        return categorieProduitRepo.findCategorie_ProduitById(id);
    }
    public void deleteProduitById(Long id){
        categorieProduitRepo.deleteById(id);
    }
}
