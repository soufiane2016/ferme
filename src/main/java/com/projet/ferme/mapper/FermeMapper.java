package com.projet.ferme.mapper;

import com.projet.ferme.domain.Ferme;
import com.projet.ferme.dto.FermeDto;
import org.springframework.stereotype.Service;

@Service
public class FermeMapper {

    public Ferme FermeFromDto(FermeDto fermeDto){
        Ferme ferme = new Ferme();
        ferme.setId(fermeDto.getId());
        ferme.setNom_ferme(fermeDto.getNom_ferme());
        ferme.setAdresse(fermeDto.getAdresse());
        ferme.setSuperficie(fermeDto.getSuperficie());
        return ferme;
    }

    public FermeDto DtoFromFerme(Ferme ferme) {
        FermeDto fermeDto = new FermeDto();
        fermeDto.setId(ferme.getId());
        fermeDto.setNom_ferme(ferme.getNom_ferme());
        fermeDto.setAdresse(ferme.getAdresse());
        fermeDto.setSuperficie(ferme.getSuperficie());
        return fermeDto;
    }
}
