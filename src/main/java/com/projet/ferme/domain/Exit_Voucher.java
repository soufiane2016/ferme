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
public class Exit_Voucher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private Long id;
	private Timestamp exit_date;
	private String observation;
	private Timestamp created_at;
	private Timestamp updates_at;
	private Timestamp deleted_at;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "exit_voucher")
	private Collection<Attachment> attachments;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "exit_voucher")
	private Collection<Line_Exit> line_Exits;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "exit_voucher")
	private Collection<Stock_Chemical_Treatment> stock_chemical_treatments;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Transportation transportation;

}
