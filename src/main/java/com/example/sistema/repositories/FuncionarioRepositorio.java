package com.example.sistema.repositories;

import com.example.sistema.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario,Long> {
}
