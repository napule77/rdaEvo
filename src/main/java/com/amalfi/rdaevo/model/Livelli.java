package com.amalfi.rdaevo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Livelli {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivello;

    @Column
    private Integer livello;

    @Column(length = 100)
    private String descrizione;

}
