package com.example.sistema.repositories;

import com.example.sistema.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
}
