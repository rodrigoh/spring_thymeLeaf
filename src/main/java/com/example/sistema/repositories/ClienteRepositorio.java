package com.example.sistema.repositories;

import com.example.sistema.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
}
