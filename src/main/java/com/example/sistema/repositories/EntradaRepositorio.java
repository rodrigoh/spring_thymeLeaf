package com.example.sistema.repositories;

import com.example.sistema.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepositorio extends JpaRepository<Entrada,Long> {
}
