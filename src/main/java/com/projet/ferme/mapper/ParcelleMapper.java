package com.projet.ferme.mapper;

import com.projet.ferme.domain.Bloc;
import com.projet.ferme.domain.Parcelle;
import com.projet.ferme.dto.ParcelleDto;
import com.projet.ferme.repositories.BlocRepo;
import org.springframework.stereotype.Service;

@Service
public class ParcelleMapper {
    private BlocRepo blocRepo;

    public ParcelleMapper(BlocRepo blocRepo) {
        this.blocRepo = blocRepo;
    }

    public Parcelle ParcelleFromDto(ParcelleDto parcelleDto) {
        Parcelle parcelle = new Parcelle();
        parcelle.setId(parcelleDto.getId());
        parcelle.setNom_parcelle(parcelleDto.getNom_parcelle());
        parcelle.setSuperficie(parcelleDto.getSuperficie());
        Bloc bloc = blocRepo.findBlocById(parcelleDto.getBlocId());
        parcelle.setBloc(bloc);
        return parcelle;
    }

    public ParcelleDto DtoFromParcelle(Parcelle parcelle) {
        ParcelleDto parcelleDto = new ParcelleDto();
        parcelleDto.setId(parcelle.getId());
        parcelleDto.setNom_parcelle(parcelle.getNom_parcelle());
        parcelleDto.setSuperficie(parcelle.getSuperficie());
        parcelleDto.setBlocId(parcelle.getBloc().getId());
        return parcelleDto;
    }
}
