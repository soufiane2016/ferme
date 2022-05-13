package com.projet.ferme.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Chemical_Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Date date_treatment;
    private Long amount_water;
    private Long bouillie;
    private String unit_bouillie;
    private Date start_time;
    private Date finish_time;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;

}
