package com.projet.ferme.services;

import com.projet.ferme.domain.Fournisseur;
import com.projet.ferme.dto.FournisseurDto;
import com.projet.ferme.mapper.FournisseurMapper;
import com.projet.ferme.repositories.FournisseurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FournisseurService {
    private FournisseurRepo fournisseurRepo;
    private FournisseurMapper fournisseurMapper;

    @Autowired
    public FournisseurService(FournisseurRepo fournisseurRepo, FournisseurMapper fournisseurMapper) {
        this.fournisseurRepo = fournisseurRepo;
        this.fournisseurMapper = fournisseurMapper;
    }

    public Fournisseur addFournisseur(FournisseurDto fournisseurDto){
        Fournisseur fournisseurFournisseur = fournisseurMapper.FournisseurFromDto(fournisseurDto);
        return fournisseurRepo.save(fournisseurFournisseur);
    }

    public Fournisseur updateFournisseur(FournisseurDto fournisseurDto){
        Fournisseur updateFournisseur = fournisseurMapper.FournisseurFromDto(fournisseurDto);
        return fournisseurRepo.save(updateFournisseur);
    }

    public List<FournisseurDto> getAllFournisseur(){
        List<Fournisseur> listFournisseurs =  fournisseurRepo.findAll();
        List<FournisseurDto> fournisseurDtoList = new ArrayList<>();
        listFournisseurs.forEach(fournisseur -> fournisseurDtoList.add(fournisseurMapper.DtoFromFournisseur(fournisseur)));
        return fournisseurDtoList;
    }
    public Fournisseur getFournisseurbyId(Long id){
        return fournisseurRepo.findFournisseurById(id);
    }
    public void deleteFournisseurById(Long id){
        fournisseurRepo.deleteById(id);
    }
}
