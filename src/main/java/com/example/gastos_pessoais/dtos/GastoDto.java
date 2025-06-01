package com.example.gastos_pessoais.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoDto {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private String tipoDeTransacao;

    public GastoDto() {

    }

    public GastoDto(Long id, String descricao, BigDecimal valor, LocalDate data, String tipoDeTransacao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipoDeTransacao = tipoDeTransacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipoDeTransacao() {
        return tipoDeTransacao;
    }

    public void setTipoDeTransacao(String tipoDeTransacao) {
        this.tipoDeTransacao = tipoDeTransacao;
    }
}
