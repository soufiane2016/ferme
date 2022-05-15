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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private String nom_produit;
	private Long quantite_disponible;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Collection<Ligne_Entree> line_Entrys;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Categorie_Produit categorie_produit;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Collection<Ligne_Sortie> ligne_sorties;
}
