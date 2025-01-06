package com.amalfi.rdaevo.repository;

import com.amalfi.rdaevo.model.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UtentiRepository extends JpaRepository<Utenti, Integer> {
    Utenti findByEmailAndPasswordAndAbilitato(String email, String password, Boolean abilitato);

    List<Utenti> findByEmail(String email);
}
