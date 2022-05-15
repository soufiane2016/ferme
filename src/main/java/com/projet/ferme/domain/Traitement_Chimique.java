package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Traitement_Chimique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Date date_traitement;
    private Long quantite_eau;
    private Long bouillie;
    private String unite_bouillie;
    private Long dose;
    private Date heur_debut;
    private Date heur_fin;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 private Stock_Traitement_Chimique stock_traitement_chimique;
	 
	 @OneToOne(cascade = CascadeType.ALL,mappedBy="traitement_chimique")
	 private Serre serre;

}
