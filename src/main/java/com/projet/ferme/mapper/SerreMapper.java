package com.projet.ferme.mapper;

import com.projet.ferme.domain.Bon_Sortie;
import com.projet.ferme.domain.Parcelle;
import com.projet.ferme.domain.Serre;
import com.projet.ferme.domain.Traitement_Chimique;
import com.projet.ferme.dto.SerreDto;
import com.projet.ferme.repositories.Bon_SortieRepo;
import com.projet.ferme.repositories.ParcelleRepo;
import com.projet.ferme.repositories.Traitement_ChimiqueRepo;
import org.springframework.stereotype.Service;

@Service
public class SerreMapper {

    private ParcelleRepo parcelleRepo;
    private Bon_SortieRepo bon_sortieRepo;
    private Traitement_ChimiqueRepo traitement_chimiqueRepo;

    public SerreMapper(ParcelleRepo parcelleRepo, Traitement_ChimiqueRepo traitement_chimiqueRepo, Bon_SortieRepo bon_sortieRepo) {
        this.parcelleRepo = parcelleRepo;
        this.traitement_chimiqueRepo = traitement_chimiqueRepo;
        this.bon_sortieRepo = bon_sortieRepo;
    }

    public Serre SerreFromDto(SerreDto serreDto) {
        Serre serre = new Serre();
        serre.setId(serreDto.getId());
        serre.setNom_serre(serreDto.getNom_serre());
        serre.setSuperficie(serreDto.getSuperficie());
        Parcelle parcelle = parcelleRepo.findParcelleById(serreDto.getParcelleId());
        serre.setParcelle(parcelle);
        return serre;
    }

    public SerreDto DtoFromSerre(Serre serre) {
        SerreDto serreDto = new SerreDto();
        serreDto.setId(serre.getId());
        serreDto.setNom_serre(serre.getNom_serre());
        serreDto.setSuperficie(serre.getSuperficie());
        serreDto.setParcelleId(serre.getParcelle().getId());
        //serreDto.setTraitement_chimiqueId(serre.getTraitement_chimique().getId());
        return serreDto;
    }
}
