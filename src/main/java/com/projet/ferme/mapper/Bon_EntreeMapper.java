package com.projet.ferme.mapper;

import com.projet.ferme.domain.Bon_Entree;
import com.projet.ferme.domain.Fournisseur;
import com.projet.ferme.dto.Bon_EntreeDto;
import com.projet.ferme.repositories.FournisseurRepo;
import org.springframework.stereotype.Service;

@Service
public class Bon_EntreeMapper {
    private FournisseurRepo fournisseurRepo;

    public Bon_EntreeMapper(FournisseurRepo fournisseurRepo) {
        this.fournisseurRepo = fournisseurRepo;
    }

    public Bon_Entree Bon_EntreeFromDto(Bon_EntreeDto bon_entreeDto) {
        Bon_Entree bon_entree = new Bon_Entree();
        bon_entree.setId(bon_entreeDto.getId());
        bon_entree.setNum_bonEntree(bon_entreeDto.getNum_bonEntree());
        bon_entree.setDate_entree(bon_entreeDto.getDate_entree());
        System.out.println(bon_entreeDto.getDate_entree());
        bon_entree.setObservation((bon_entreeDto.getObservation()));
        Fournisseur fournisseur = fournisseurRepo.findFournisseurById(bon_entreeDto.getFournisseurId());
        bon_entree.setFournisseur(fournisseur);
        return bon_entree;
    }

    public Bon_EntreeDto DtoFromBon_Entree(Bon_Entree bon_entree) {
        Bon_EntreeDto bon_entreeDto = new Bon_EntreeDto();
        bon_entreeDto.setId(bon_entree.getId());
        bon_entreeDto.setNum_bonEntree(bon_entree.getNum_bonEntree());
        bon_entreeDto.setDate_entree(bon_entree.getDate_entree());
        bon_entreeDto.setObservation(bon_entree.getObservation());
        bon_entreeDto.setFournisseurId(bon_entree.getFournisseur().getId());
        return bon_entreeDto;
    }
}
