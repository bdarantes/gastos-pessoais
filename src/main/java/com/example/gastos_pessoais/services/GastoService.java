package com.example.gastos_pessoais.services;

import com.example.gastos_pessoais.dtos.GastoDto;
import com.example.gastos_pessoais.entities.Gasto;
import com.example.gastos_pessoais.mappers.GastoMapper;
import com.example.gastos_pessoais.repositories.GastoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GastoService {

    private final GastoRepository gastoRepository;
    private final GastoMapper gastoMapper;

    public GastoService(GastoRepository gastoRepository, GastoMapper gastoMapper) {
        this.gastoRepository =gastoRepository;
        this.gastoMapper = gastoMapper;
    }


    public GastoDto salvar(GastoDto gastoDto) {
        Gasto gasto = gastoMapper.toEntity(gastoDto);
        Gasto gastoSalvo = gastoRepository.save(gasto);
        return gastoMapper.toDto(gastoSalvo);
    }




    public List<GastoDto> mostrarTodos() {
        return  gastoRepository.findAll()
                .stream()
                .map(gastoMapper::toDto)
                .collect(Collectors.toList());
    }

    public GastoDto buscarPorId(Long id) {
        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Gasto não encontrado"));
        return gastoMapper.toDto(gasto);
    }

    public GastoDto atualizar(Long id, GastoDto dto) {
        Gasto gastoAtualizado = gastoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Gasto não encontrado"));
        return  gastoMapper.toDto(gastoAtualizado);
    }

    public boolean deletar(Long id) {
        if(!gastoRepository.existsById(id)) {
            throw  new RuntimeException("Gasto não encontrado");
        }
        gastoRepository.deleteById(id);
        return  false;
    }


}
