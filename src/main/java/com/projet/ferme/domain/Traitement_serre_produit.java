package com.projet.ferme.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Traitement_serre_produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private Long qte_utilise;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JsonBackReference(value = "serre_trait")
    private Serre serre;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JsonBackReference(value = "traitement_chimique_trait")
    private Traitement_Chimique traitement_chimique;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JsonBackReference(value = "stock_trait")
    private Stock_Traitement_Chimique stock_traitement_chimique;
}
