package com.amalfi.rdaevo.repository;

import com.amalfi.rdaevo.model.Rda;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RdaRepository extends JpaRepository<Rda, Integer> {
    List<Rda> findByLivelloApp(int livello);

    List<Rda> findByUserEmailRda(@Size(max = 100) String userEmailRda);

    List<Rda> findByUserEmailRdaOrderByDataRdaDesc(@Size(max = 100) String userEmailRda);
}
