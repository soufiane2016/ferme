package com.projet.ferme.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProduitDto {
    private Long id;
    private String nom_produit;
    private Long quantite_disponible;
    private Date date_exp;
    private Long categorie_produitId;
}
