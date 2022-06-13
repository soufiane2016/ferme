package com.projet.ferme.services;

import com.projet.ferme.domain.Ferme;
import com.projet.ferme.dto.FermeDto;
import com.projet.ferme.mapper.FermeMapper;
import com.projet.ferme.repositories.FermeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FermeService {
    private FermeRepo fermeRepo;
    private FermeMapper fermeMapper;

    public FermeService(FermeRepo fermeRepo, FermeMapper fermeMapper) {
        this.fermeRepo = fermeRepo;
        this.fermeMapper = fermeMapper;
    }

    public Ferme addFerme(FermeDto fermeDto){
        Ferme ferme = fermeMapper.FermeFromDto(fermeDto);
        return fermeRepo.save(ferme);
    }

    public Ferme updateFerme(FermeDto fermeDto){
        Ferme updateFerme = fermeMapper.FermeFromDto(fermeDto);
        return fermeRepo.save(updateFerme);
    }

    public List<FermeDto> getAllFerme(){
        List<Ferme> listFermes =  fermeRepo.findAll();
        List<FermeDto> fermeDtoList = new ArrayList<>();
        listFermes.forEach(ferme -> fermeDtoList.add(fermeMapper.DtoFromFerme(ferme)));
        return fermeDtoList;
    }
    public Ferme getFermebyId(Long id){
        return fermeRepo.findFermeById(id);
    }
    public void deleteFermeById(Long id){
        fermeRepo.deleteById(id);
    }

}
