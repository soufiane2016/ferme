package com.projet.ferme.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SerreDto {
    private Long id;
    private String nom_serre;
    private Long superficie;
    private Timestamp created_at;
    private Timestamp updates_at;
    private Timestamp deleted_at;
    private Long parcelleId;
}
