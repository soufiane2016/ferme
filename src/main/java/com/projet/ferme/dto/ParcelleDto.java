package com.projet.ferme.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ParcelleDto {
    private Long id;
    private String nom_parcelle;
    private Long superficie;
    private Timestamp created_at;
    private Timestamp updates_at;
    private Timestamp deleted_at;
    private Long blocId;
}
