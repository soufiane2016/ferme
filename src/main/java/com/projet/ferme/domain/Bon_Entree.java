package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

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
public class Bon_Entree {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Date date_entree;
	private String observation;
	private Long num_bonEntree;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "bonEntree_fournisseur")
	private Fournisseur fournisseur;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="bon_entree")
	@JsonManagedReference(value = "attachment_bonEntree")
	private Collection<Attachment> attachments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="bon_entree")
	@JsonManagedReference(value = "ligneEntree_bonEntree")
	private Collection<Ligne_Entree> ligne_entrees;

}
