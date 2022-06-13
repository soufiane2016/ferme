package com.projet.ferme.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Categorie_ProduitDto {
    private Long id;
    private String nom_categorie;
    private Timestamp created_at;
    private Timestamp updates_at;
    private Timestamp deleted_at;
}
