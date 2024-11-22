package br.com.fiap.gs.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class UsinaSolar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String local;

    @Column(nullable = false)
    private LocalDate inicioOperacao;

    @Column(precision = 16, scale = 2)
    private BigDecimal CapacidadeEnergia;

    @Column(precision = 16, scale = 2)
    private BigDecimal Area;

    @Column(precision = 16, scale = 2)
    private BigDecimal QuantidadePaineis;
}
