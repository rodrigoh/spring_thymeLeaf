package com.example.sistema.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Entrada implements Serializable {
  private static final Long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String obs;
  private Double valorTotal;
  private Double quantidadeTotal;
  private Date dataEntrada;
  @ManyToOne
  private Fornecedor fornecedor;
  @ManyToOne
  private Funcionario funcionario;


  public Entrada(){
    valorTotal = 0.0;
    quantidadeTotal = 0.0;
    dataEntrada = new Date();
  }

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

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Double getQuantidadeTotal() {
    return quantidadeTotal;
  }

  public void setQuantidadeTotal(Double quantidadeTotal) {
    this.quantidadeTotal = quantidadeTotal;
  }

  public Date getDataEntrada() {
    return dataEntrada;
  }

  public void setDataEntrada(Date dataEntrada) {
    this.dataEntrada = dataEntrada;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }
}
