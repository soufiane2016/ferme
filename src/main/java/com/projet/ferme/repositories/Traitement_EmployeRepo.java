package com.projet.ferme.repositories;

import com.projet.ferme.domain.Traitement_Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Traitement_EmployeRepo extends JpaRepository<Traitement_Employe, Long> {
    public Traitement_Employe findTraitement_EmployeById(Long id);
    void deleteById(Long id);
}
