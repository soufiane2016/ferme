package com.projet.ferme.mapper;

import com.projet.ferme.domain.Fournisseur;
import com.projet.ferme.dto.FournisseurDto;
import org.springframework.stereotype.Service;

@Service
public class FournisseurMapper {
    public Fournisseur FournisseurFromDto(FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom_fournisseur(fournisseurDto.getNom_fournisseur());
        return fournisseur;
    }

    public FournisseurDto DtoFromFournisseur(Fournisseur fournisseur) {
        FournisseurDto fournisseurDto = new FournisseurDto();
        fournisseurDto.setId(fournisseur.getId());
        fournisseurDto.setNom_fournisseur(fournisseur.getNom_fournisseur());
        return fournisseurDto;
    }
}
