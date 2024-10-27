package com.example.sistema.repositories;


import com.example.sistema.model.ItemEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEntradaRepositorio extends JpaRepository<ItemEntrada,Long> {
}
