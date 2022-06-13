package com.projet.ferme.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BlocDto {
    private Long id;
    private String nom_bloc;
    private Long superficie;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
    private Long fermeId;
}
