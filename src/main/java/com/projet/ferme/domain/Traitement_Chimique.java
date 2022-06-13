package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

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


	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "traitement_chimique")
	 @JsonManagedReference(value = "traitement_employe")
	 private Collection<Traitement_Employe> traitement_employes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="traitement_chimique")
	@JsonManagedReference(value = "traitement_chimique_trait")
	private Collection<Traitement_serre_produit> traitement_serre_produits;



}
