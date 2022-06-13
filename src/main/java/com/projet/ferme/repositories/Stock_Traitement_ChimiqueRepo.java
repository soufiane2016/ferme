package com.projet.ferme.repositories;

import com.projet.ferme.domain.Stock_Traitement_Chimique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Stock_Traitement_ChimiqueRepo extends JpaRepository<Stock_Traitement_Chimique, Long> {
    public Stock_Traitement_Chimique findStock_Traitement_ChimiqueById(Long id);
    void deleteById(Long id);
}
