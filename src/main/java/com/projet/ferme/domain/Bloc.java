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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private String nom_bloc;
	private Long superficie;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference(value = "bloc_ferme")
	private Ferme ferme;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="bloc")
	@JsonManagedReference(value = "bloc_parcelle")
	private Collection<Parcelle> parcelles;

}
