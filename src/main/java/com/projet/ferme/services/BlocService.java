package com.projet.ferme.services;

import com.projet.ferme.domain.Bloc;
import com.projet.ferme.dto.BlocDto;
import com.projet.ferme.mapper.BlocMapper;
import com.projet.ferme.repositories.BlocRepo;
import com.projet.ferme.repositories.FermeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlocService {
    private BlocRepo blocRepo;
    private FermeRepo fermeRepo;
    private BlocMapper blocMapper;

    public BlocService(BlocRepo blocRepo, FermeRepo fermeRepo, BlocMapper blocMapper) {
        this.blocRepo = blocRepo;
        this.fermeRepo = fermeRepo;
        this.blocMapper = blocMapper;

    }

    public Bloc addBloc(BlocDto blocDto){
        Bloc bloc = blocMapper.BlocFromDto(blocDto);
        return blocRepo.save(bloc);
    }
    public Bloc updateBloc(BlocDto blocDto){
        Bloc bloc = blocMapper.BlocFromDto(blocDto);
        return blocRepo.save(bloc);
    }
    public List<BlocDto> getAllBlocs(){
        List<Bloc> blocList = blocRepo.findAll();
        List<BlocDto> blocDtoList = new ArrayList<>();
        blocList.forEach(bloc -> blocDtoList.add(blocMapper.DtoFromBloc(bloc)));
        return blocDtoList;
    }
    public Bloc getBlocById(Long id){
        return blocRepo.findBlocById(id);
    }
    public void deleteBlocById(Long id){
        blocRepo.deleteById(id);
    }
}
