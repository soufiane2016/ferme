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
public class Ligne_Sortie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Long quantite_sortie;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "ligneSortie_produit")
	private Produit produit;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "ligneEntree_bonSortie")
	private Bon_Sortie bon_sortie;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="ligne_sortie")
	@JsonManagedReference(value = "ligneSortie_stock")
	private Collection<Stock_Traitement_Chimique> stock_traitement_chimiques;
}
