package com.example.sistema.repositories;

import com.example.sistema.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepositorio extends JpaRepository<Fornecedor,Long> {
}
