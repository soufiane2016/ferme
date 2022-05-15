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
public class Bon_Entree {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Timestamp date_entree;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Fournisseur fournisseur;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="bon_entree")
	private Collection<Attachment> attachments;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="bon_entree")
	private Collection<Ligne_Entree> ligne_entrees;

}
