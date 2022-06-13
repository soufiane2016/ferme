package com.projet.ferme.repositories;

import com.projet.ferme.domain.Traitement_Chimique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Traitement_ChimiqueRepo extends JpaRepository<Traitement_Chimique, Long> {
    public Traitement_Chimique findTraitement_ChimiqueById(Long id);
    void deleteById(Long id);
}
