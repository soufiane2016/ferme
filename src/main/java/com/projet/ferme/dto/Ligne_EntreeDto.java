package com.projet.ferme.dto;

import lombok.Data;

@Data
public class Ligne_EntreeDto {
    private Long id;
    private Long prix;
    private String unite;
    private Long quantite;
    private Long bonEntreeId;
    private Long produitId;
    private String nom_produit;

}
