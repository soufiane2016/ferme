package com.projet.ferme.domain;

import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ligne_Entree {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Long prix;
	private Long quantite;
	private String unite;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JsonBackReference(value = "ligneEntree_produit")
	private Produit produit;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "ligneEntree_bonEntree")
	private Bon_Entree bon_entree;
}
