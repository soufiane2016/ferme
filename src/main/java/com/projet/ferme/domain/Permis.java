package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Permis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private String num_permis;
	private String type_permis;
	private Date date_fin_validation;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Chauffeur chauffeur;

}
