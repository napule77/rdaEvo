package com.amalfi.rdaevo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Utenze {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtenza;

    @Column
    private Integer idUtente;

    @Column
    private Integer livello;

}
