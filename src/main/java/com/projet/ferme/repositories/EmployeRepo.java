package com.projet.ferme.repositories;

import com.projet.ferme.domain.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employe, Long> {
    public Employe findEmployeById(Long id);
    void deleteById(Long id);
}
