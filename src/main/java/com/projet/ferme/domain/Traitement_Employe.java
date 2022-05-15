package com.projet.ferme.domain;

import java.sql.Timestamp;
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
public class Traitement_Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employe employe;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Traitement_Chimique traitement_chimique;

}
