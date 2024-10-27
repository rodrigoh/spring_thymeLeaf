package com.example.sistema.repositories;

import com.example.sistema.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade,Long> {
}
