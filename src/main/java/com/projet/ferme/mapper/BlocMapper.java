package com.projet.ferme.mapper;

import com.projet.ferme.domain.Bloc;
import com.projet.ferme.domain.Ferme;
import com.projet.ferme.dto.BlocDto;
import com.projet.ferme.repositories.FermeRepo;
import org.springframework.stereotype.Service;

@Service
public class BlocMapper {
    private FermeRepo fermeRepo;
    public BlocMapper(FermeRepo fermeRepo) {
        this.fermeRepo = fermeRepo;
    }
    public Bloc BlocFromDto(BlocDto blocDto) {
        Bloc bloc = new Bloc();
        bloc.setId(blocDto.getId());
        bloc.setNom_bloc(blocDto.getNom_bloc());
        bloc.setSuperficie(blocDto.getSuperficie());
        Ferme ferme = fermeRepo.findFermeById(blocDto.getFermeId());
        bloc.setFerme(ferme);
        return bloc;
    }

    public BlocDto DtoFromBloc(Bloc bloc){
        BlocDto blocDto = new BlocDto();
        blocDto.setId(bloc.getId());
        blocDto.setNom_bloc(bloc.getNom_bloc());
        blocDto.setSuperficie(bloc.getSuperficie());
        blocDto.setFermeId(bloc.getFerme().getId());
        return blocDto;
    }
}
