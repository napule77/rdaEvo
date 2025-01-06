package com.amalfi.rdaevo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
public class Utenti {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtente;

    @Column(length = 100)
    private String nome;

    @Column(length = 100)
    private String cognome;

    @Column(nullable = false, unique = true, length = 200)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(columnDefinition = "tinyint", length = 1)
    private Boolean abilitato;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone = "Europe/Rome")
    private Date dataInsert;

}
