package com.amalfi.rdaevo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "detailrda")
public class Detailrda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetail", nullable = false)
    private Integer id;

    @Column(name = "riga")
    private Integer riga;

    @Size(max = 100)
    @Column(name = "codprod", length = 100)
    private String codprod;

    @Size(max = 100)
    @Column(name = "descprod", length = 100)
    private String descprod;

    @Column(name = "qta", precision = 10)
    private BigDecimal qta;

    @Size(max = 100)
    @Column(name = "nota", length = 100)
    private String nota;

    @Size(max = 100)
    @Column(name = "unit", length = 100)
    private String unit;

    @Size(max = 100)
    @Column(name = "numRda", length = 100)
    private String numRda;

}