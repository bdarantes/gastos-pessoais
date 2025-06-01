package com.example.gastos_pessoais.mappers;


import com.example.gastos_pessoais.dtos.GastoDto;
import com.example.gastos_pessoais.entities.Gasto;

public class GastoMapper {
    public GastoDto gastoDto(Gasto gasto) {
        if(gasto ==null) {
            return  null;
        }
        GastoDto dto = new GastoDto();
        dto.setId(gasto.getId());
        dto.setValor(gasto.getValor());
        dto.setData(gasto.getData());
        dto.setDescricao(gasto.getDescricao());
        dto.setTipoDeTransacao(gasto.getTipoDeTransacao());
        return dto;
    }

    public Gasto toEntity(GastoDto gastoDto) {
        if(gastoDto ==null) {
            return  null;
        }
        Gasto gasto = new Gasto();
        gasto.setId(gastoDto.getId());
        gasto.setValor(gastoDto.getValor());
        gasto.setData(gastoDto.getData());
        gasto.setDescricao(gastoDto.getDescricao());
        gasto.setTipoDeTransacao(gastoDto.getTipoDeTransacao());
        return  gasto;
    }
}
