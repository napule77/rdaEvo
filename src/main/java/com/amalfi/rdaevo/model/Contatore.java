package com.amalfi.rdaevo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contatore")
public class Contatore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContatore", nullable = false)
    private Integer id;

    @Column(name = "valore")
    private Integer valore;

    @Column(name = "anno")
    private Integer anno;

}