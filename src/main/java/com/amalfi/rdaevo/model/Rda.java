package com.amalfi.rdaevo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "rda")
public class Rda {
    @Id
    @Column(name = "idRda", nullable = false)
    private Integer id;

    @Column(name = "dataRda")
    private Date dataRda;

    @Size(max = 100)
    @Column(name = "numRda", length = 100)
    private String numRda;

    @Size(max = 100)
    @Column(name = "userEmailRda", length = 100)
    private String userEmailRda;

    @Column(name = "livelloApp")
    private Integer livelloApp;

    @Size(max = 10)
    @NotNull
    @Column(name = "commessa", nullable = false, length = 10)
    private String commessa;

    @Column(name = "annocommessa")
    private Integer annocommessa;

}