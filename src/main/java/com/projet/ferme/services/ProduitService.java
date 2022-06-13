package com.projet.ferme.services;

import com.projet.ferme.domain.Produit;
import com.projet.ferme.dto.ProduitDto;
import com.projet.ferme.mapper.ProduitMapper;
import com.projet.ferme.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {

    private ProduitRepo produitRepo;
    private ProduitMapper produitMapper;

    @Autowired
    public ProduitService(ProduitRepo produitRepo, ProduitMapper produitMapper) {
        this.produitRepo = produitRepo;
        this.produitMapper = produitMapper;
    }

    public Produit addProduit(ProduitDto produitDto){
        Produit produit = produitMapper.ProduitFromDto(produitDto);
        return produitRepo.save(produit);
    }

    public Produit updateProduit(ProduitDto ProduitDto){
        Produit updateProduit = produitMapper.ProduitFromDto(ProduitDto);
        return produitRepo.save(updateProduit);
    }

    public List<ProduitDto> getAllProduit(){
        List<Produit> listProduits =  produitRepo.findAll();
        List<ProduitDto> produitDtoList = new ArrayList<>();
        listProduits.forEach(produit -> produitDtoList.add(produitMapper.DtoFromProduit(produit)));
        return produitDtoList;
    }
    public Produit getProduitbyId(Long id){
        return produitRepo.findProduitById(id);
    }
    public void deleteProduitById(Long id){
        produitRepo.deleteById(id);
    }
}
