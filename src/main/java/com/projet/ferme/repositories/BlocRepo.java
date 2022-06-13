package com.projet.ferme.repositories;

import com.projet.ferme.domain.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlocRepo  extends JpaRepository<Bloc, Long> {
    public Bloc findBlocById(Long id);
    void deleteById(Long id);
}
