package com.amalfi.rdaevo.repository;

import com.amalfi.rdaevo.model.Contatore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoreRepository extends JpaRepository<Contatore, Integer> {

    Contatore findByAnno(int anno);
}
