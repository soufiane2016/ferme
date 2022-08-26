package com.projet.ferme.services;

import com.projet.ferme.domain.Bon_Entree;
import com.projet.ferme.domain.Ligne_Entree;
import com.projet.ferme.dto.Ligne_EntreeDto;
import com.projet.ferme.mapper.Ligne_EntreeMapper;
import com.projet.ferme.repositories.Bon_EntreeRepo;
import com.projet.ferme.repositories.Ligne_EntreeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LigneEntreeService {

    private Ligne_EntreeRepo ligne_EntreeRepo;
    private Bon_EntreeRepo bon_entreeRepo;
    private Ligne_EntreeMapper ligne_EntreeMapper;
    int i = 0;

    public LigneEntreeService(Ligne_EntreeRepo ligne_EntreeRepo, Ligne_EntreeMapper ligne_EntreeMapper, Bon_EntreeRepo bon_entreeRepo) {
        this.ligne_EntreeRepo = ligne_EntreeRepo;
        this.ligne_EntreeMapper = ligne_EntreeMapper;
        this.bon_entreeRepo = bon_entreeRepo;
    }

    public Ligne_Entree addLigneEntree(Ligne_EntreeDto ligne_EntreeDto){
        Ligne_Entree ligne_Entree = ligne_EntreeMapper.Ligne_EntreeFromDto(ligne_EntreeDto);
        return ligne_EntreeRepo.save(ligne_Entree);
    }

    public Ligne_Entree updateLigneEntree(Ligne_EntreeDto ligne_EntreeDto){
        Ligne_Entree updateLigne_Entree = ligne_EntreeMapper.Ligne_EntreeFromDto(ligne_EntreeDto);
        return ligne_EntreeRepo.save(updateLigne_Entree);
    }

    public List<Ligne_EntreeDto> getAllLigneEntree(){
        List<Ligne_Entree> ligne_EntreeList = ligne_EntreeRepo.findAll();
        List<Ligne_EntreeDto> ligne_EntreeDtoList = new ArrayList<>();
        ligne_EntreeList.forEach(ligne_Entree -> ligne_EntreeDtoList.add(ligne_EntreeMapper.DtoFromLigne_Entree(ligne_Entree)));
        return ligne_EntreeDtoList;
    }

    public List<Ligne_EntreeDto> getAllLigneEntreeBonEntree(Long idBon){
        List<Ligne_Entree> ligne_EntreeList = ligne_EntreeRepo.findAll();
        List<Ligne_EntreeDto> ligne_EntreeDtoList = new ArrayList<>();
        for(Ligne_Entree ligneEntreeBon: ligne_EntreeList){
            if (ligneEntreeBon.getBon_entree().getNum_bonEntree() == idBon.longValue()){
                i++;
                //ligne_EntreeList.forEach(ligne_Entree -> ligne_EntreeDtoList.add(ligne_EntreeMapper.DtoFromLigne_Entree(ligne_Entree)));
                ligne_EntreeDtoList.add(ligne_EntreeMapper.DtoFromLigne_Entree(ligneEntreeBon));
            }
        }
        System.out.println(i);
        return ligne_EntreeDtoList;
    }

    public Ligne_EntreeDto getLigneEntreebyId(Long id){
        Ligne_Entree ligneEntree = ligne_EntreeRepo.findLigne_EntreeById(id);
        Ligne_EntreeDto ligneEntreeDto = ligne_EntreeMapper.DtoFromLigne_Entree(ligneEntree);
        return ligneEntreeDto;
    }

    /*public List<Ligne_Entree> getLigneEntreeByBonId(Long bonId){
        Bon_Entree bonEntrees = bon_entreeRepo.findBon_EntreeById(bonId);
        List<Ligne_Entree> ligneEntree = ligne_EntreeRepo.findLigne_EntreeByBon_entree(bonEntrees);
        return ligneEntree;
    }*/


    public void deleteLigneEntreeById(Long id){
        ligne_EntreeRepo.deleteById(id);
    }
}
