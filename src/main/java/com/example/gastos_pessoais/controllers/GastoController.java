package com.example.gastos_pessoais.controllers;

import com.example.gastos_pessoais.dtos.GastoDto;
import com.example.gastos_pessoais.entities.Gasto;
import com.example.gastos_pessoais.services.GastoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }


    public ResponseEntity<GastoDto>  criarGasto(@RequestBody GastoDto gastoDto) {
        GastoDto gastoCriado = gastoService.salvar(gastoDto);
        return new ResponseEntity<>(gastoCriado, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<GastoDto>>listarGastos() {
        List<GastoDto> gastos = gastoService.mostrarTodos();
        return  new ResponseEntity<>(gastos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GastoDto>buscarPorId(@PathVariable Long id) {
        GastoDto gasto = gastoService.buscarPorId(id);
        return ResponseEntity.ok(gasto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GastoDto>atualizarProduto(@PathVariable Long id, @RequestBody GastoDto gastoDto) {
        GastoDto gastoAtualizado = gastoService.atualizar(id, gastoDto);
        return gastoAtualizado != null ? new ResponseEntity<>(gastoAtualizado, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGasto(@PathVariable Long id) {
        boolean deletado = gastoService.deletar(id);
        return  deletado ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
