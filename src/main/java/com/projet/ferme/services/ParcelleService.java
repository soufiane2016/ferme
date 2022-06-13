package com.projet.ferme.services;

import com.projet.ferme.domain.Parcelle;
import com.projet.ferme.dto.ParcelleDto;
import com.projet.ferme.mapper.ParcelleMapper;
import com.projet.ferme.repositories.BlocRepo;
import com.projet.ferme.repositories.ParcelleRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParcelleService {
    private ParcelleRepo parcelleRepo;
    private ParcelleMapper parcelleMapper;

    public ParcelleService(ParcelleRepo parcelleRepo, ParcelleMapper parcelleMapper) {
        this.parcelleRepo = parcelleRepo;
        this.parcelleMapper = parcelleMapper;
    }

    public Parcelle addParcelle(ParcelleDto parcelleDto){
        Parcelle parcelle = parcelleMapper.ParcelleFromDto(parcelleDto);
        return parcelleRepo.save(parcelle);
    }

    public Parcelle updateParcelle(ParcelleDto parcelleDto){
        Parcelle updateParcelle = parcelleMapper.ParcelleFromDto(parcelleDto);
        return parcelleRepo.save(updateParcelle);
    }

    public List<ParcelleDto> getAllParcelle(){
        List<Parcelle> parcelleList = parcelleRepo.findAll();
        List<ParcelleDto> parcelleDtoList = new ArrayList<>();
        parcelleList.forEach(parcelle -> parcelleDtoList.add(parcelleMapper.DtoFromParcelle(parcelle)));

        return parcelleDtoList;
    }

    public Parcelle getParcellebyId(Long id){
        return parcelleRepo.findParcelleById(id);
    }
    public void deleteParcelleById(Long id){
        parcelleRepo.deleteById(id);
    }
}
