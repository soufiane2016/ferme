package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ferme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private String nom_ferme;
	private String adresse;
	private Long superficie;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="ferme")
	private Collection<Bloc> blocs;
}
