package br.com.fiap.gs.views;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface UsinaSolarCompleteView {
    Long getId();
    String getLocal();
    LocalDate getInicioOperacao();
    BigDecimal getCapacidadeEnergia();
    BigDecimal getArea();
    BigDecimal getQuantidadePaineis();
}
