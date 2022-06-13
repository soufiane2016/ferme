package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private String immatricule;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="transport")
	@JsonManagedReference(value = "transport_voyage")
	private Collection<Voyage> voyages;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="transport")
	@JsonManagedReference(value = "bonSortie_transport")
	private Collection<Bon_Sortie> bon_sorties;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "chauffeur_transport")
	private Chauffeur chauffeur;
	
	
}
