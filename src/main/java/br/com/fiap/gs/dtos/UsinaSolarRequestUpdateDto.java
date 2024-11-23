package br.com.fiap.gs.dtos;

import br.com.fiap.gs.model.UsinaSolar;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UsinaSolarRequestUpdateDto {

    private String local;
    private LocalDate inicioOperacao;
    private BigDecimal CapacidadeEnergia;
    private BigDecimal Area;
    private BigDecimal QuantidadePaineis;
    private static final ModelMapper modelMapper = new ModelMapper();

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDate getInicioOperacao() {
        return inicioOperacao;
    }

    public void setInicioOperacao(LocalDate inicioOperacao) {
        this.inicioOperacao = inicioOperacao;
    }

    public BigDecimal getCapacidadeEnergia() {
        return CapacidadeEnergia;
    }

    public void setCapacidadeEnergia(BigDecimal capacidadeEnergia) {
        CapacidadeEnergia = capacidadeEnergia;
    }

    public BigDecimal getArea() {
        return Area;
    }

    public void setArea(BigDecimal area) {
        Area = area;
    }

    public BigDecimal getQuantidadePaineis() {
        return QuantidadePaineis;
    }

    public void setQuantidadePaineis(BigDecimal quantidadePaineis) {
        QuantidadePaineis = quantidadePaineis;
    }

    public UsinaSolar toModel(Long id) {
        UsinaSolar result = modelMapper.map(this, UsinaSolar.class);
        result.setId(id);
        return result;
    }
}
