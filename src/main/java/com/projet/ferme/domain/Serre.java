package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Serre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private String nom_serre;
	private Long superficie;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;

	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "parcelle_serre")
	private Parcelle parcelle;

	@Nullable
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "serre")
	@JsonBackReference(value = "bonSortie_serre")
	private Bon_Sortie bon_sortie;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="serre")
	@JsonManagedReference(value = "serre_trait")
	private Collection<Traitement_serre_produit> traitement_serre_produits;
	
}
