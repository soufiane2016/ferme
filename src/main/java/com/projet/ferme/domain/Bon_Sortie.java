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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bon_Sortie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Timestamp date_sortie;
	private String observation;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bon_sortie")
	@JsonManagedReference(value = "attachment_bonSortie")
	private Collection<Attachment> attachments;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bon_sortie")
	@JsonManagedReference(value = "ligneEntree_bonSortie")
	private Collection<Ligne_Sortie> ligne_sorties;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "bonSortie_transport")
	private Transport transport;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference(value = "bonSortie_serre")
	private Serre serre;

}
