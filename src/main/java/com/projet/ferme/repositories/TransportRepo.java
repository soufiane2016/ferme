package com.projet.ferme.repositories;

import com.projet.ferme.domain.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepo extends JpaRepository<Transport,Long> {
    public Transport findTransportById(Long id);
    void deleteById(Long id);
}
