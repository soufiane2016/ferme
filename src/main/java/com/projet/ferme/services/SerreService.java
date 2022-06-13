package com.projet.ferme.services;

import com.projet.ferme.domain.Serre;
import com.projet.ferme.dto.SerreDto;
import com.projet.ferme.mapper.SerreMapper;
import com.projet.ferme.repositories.SerreRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerreService {
    private SerreRepo serreRepo;
    private SerreMapper serreMapper;

    public SerreService(SerreRepo serreRepo, SerreMapper serreMapper) {
        this.serreRepo = serreRepo;
        this.serreMapper = serreMapper;
    }

    public Serre addSerre(SerreDto serreDto){
        Serre serre = serreMapper.SerreFromDto(serreDto);
        return serreRepo.save(serre);
    }

    public Serre updateSerre(SerreDto serreDto){
        Serre updateSerre = serreMapper.SerreFromDto(serreDto);
        return serreRepo.save(updateSerre);
    }

    public List<SerreDto> getAllSerre(){
        List<Serre> serreList = serreRepo.findAll();
        List<SerreDto> serreDtoList = new ArrayList<>();
        serreList.forEach(serre -> serreDtoList.add(serreMapper.DtoFromSerre(serre)));

        return serreDtoList;
    }

    public Serre getSerrebyId(Long id){
        return serreRepo.findSerreById(id);
    }
    public void deleteSerreById(Long id){
        serreRepo.deleteById(id);
    }
}
