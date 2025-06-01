package com.example.gastos_pessoais.repositories;

import com.example.gastos_pessoais.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
