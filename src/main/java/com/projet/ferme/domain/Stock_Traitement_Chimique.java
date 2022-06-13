package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stock_Traitement_Chimique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Long quantite_disponible;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "ligneSortie_stock")
	private Ligne_Sortie ligne_sortie;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock_traitement_chimique")
	@JsonManagedReference(value = "stock_trait")
	private Collection<Traitement_serre_produit> traitement_serre_produits;

}
