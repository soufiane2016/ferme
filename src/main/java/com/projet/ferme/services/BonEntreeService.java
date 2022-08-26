package com.projet.ferme.services;

import com.projet.ferme.domain.Bon_Entree;
import com.projet.ferme.dto.Bon_EntreeDto;
import com.projet.ferme.mapper.Bon_EntreeMapper;
import com.projet.ferme.repositories.Bon_EntreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BonEntreeService {
    private Bon_EntreeRepo bon_entreeRepo;
    private Bon_EntreeMapper bon_entreeMapper;

    @Autowired
    public BonEntreeService(Bon_EntreeRepo bon_entreeRepo, Bon_EntreeMapper bon_entreeMapper) {
        this.bon_entreeRepo = bon_entreeRepo;
        this.bon_entreeMapper = bon_entreeMapper;
    }

    public Bon_Entree addBonEntree(Bon_EntreeDto bon_entreeDto){
        Bon_Entree bonEntree = bon_entreeMapper.Bon_EntreeFromDto(bon_entreeDto);
        return bon_entreeRepo.save(bonEntree);
    }

    public Bon_Entree updateBonEntree(Bon_EntreeDto bon_entreeDto){
        Bon_Entree updateBonEntree = bon_entreeMapper.Bon_EntreeFromDto(bon_entreeDto);
        return bon_entreeRepo.save(updateBonEntree);
    }

    public List<Bon_EntreeDto> getAllBonEntree(){
        List<Bon_Entree> listBonEntrees =  bon_entreeRepo.findAll();
        List<Bon_EntreeDto> BonEntreeDtoList = new ArrayList<>();
        listBonEntrees.forEach(bonEntree -> BonEntreeDtoList.add(bon_entreeMapper.DtoFromBon_Entree(bonEntree)));
        return BonEntreeDtoList;
    }
    public Bon_Entree getBonEntreebyId(Long id){
        return bon_entreeRepo.findBon_EntreeById(id);
    }
    public void deleteBonEntreeById(Long id){
        bon_entreeRepo.deleteById(id);
    }
}
