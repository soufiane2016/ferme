package com.projet.ferme.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Bon_EntreeDto {
    private Long id;
    private Long num_bonEntree;
    private Date date_entree;
    private String observation;
    private Long fournisseurId;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
