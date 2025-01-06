package com.amalfi.rdaevo.repository;

import com.amalfi.rdaevo.model.UtenzaView;
import com.amalfi.rdaevo.model.Utenze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UtenzeRepository extends JpaRepository<Utenze, Integer> {
    List<Utenze> findByIdUtente(Integer idUtente);

    @Query(value = "select * from utenzaview where idUtente=:idUtente",nativeQuery = true)
    List<UtenzaView> findUtenzaExp(int idUtente);

    Utenze findByIdUtenteAndLivello(Integer idUtente, Integer livello);


}
