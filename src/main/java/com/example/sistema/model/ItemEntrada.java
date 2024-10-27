package com.example.sistema.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class ItemEntrada implements Serializable {
  private static final Long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String obs;
  private Double quantidade;
  private Double valor;
  @ManyToOne
  private Produto produto;
  @ManyToOne
  private Entrada entrada;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public Double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Double quantidade) {
    this.quantidade = quantidade;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Entrada getEntrada() {
    return entrada;
  }

  public void setEntrada(Entrada entrada) {
    this.entrada = entrada;
  }
}
