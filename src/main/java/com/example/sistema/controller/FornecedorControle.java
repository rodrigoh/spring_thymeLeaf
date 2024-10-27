package com.example.sistema.controller;

import com.example.sistema.model.Fornecedor;
import com.example.sistema.repositories.CidadeRepositorio;
import com.example.sistema.repositories.FornecedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class FornecedorControle {

  @Autowired
  private FornecedorRepositorio fornecedorRepositorio;

  @Autowired
  private CidadeRepositorio cidadeRepositorio;

  @GetMapping("/cadastroFornecedor")
  public ModelAndView cadastrar(Fornecedor fornecedor){
    ModelAndView mv = new ModelAndView("administrativo/fornecedores/cadastro");
    mv.addObject("fornecedor",fornecedor);
    mv.addObject("listaCidades",cidadeRepositorio.findAll());
    return mv;
  }

  //Recebemos o parâmetro
  @GetMapping("/editarFornecedor/{id}")
  public ModelAndView editar(@PathVariable("id") Long id){
    Optional<Fornecedor> fornecedor = fornecedorRepositorio.findById(id);
    return cadastrar(fornecedor.get());
  }

  //Recebemos o parâmetro
  @GetMapping("/removerFornecedor/{id}")
  public ModelAndView remover(@PathVariable("id") Long id){
    Optional<Fornecedor> fornecedor = fornecedorRepositorio.findById(id);
    fornecedorRepositorio.delete(fornecedor.get());
    return listar();
  }

  @GetMapping("/listarFornecedor")
  public ModelAndView listar(){
    ModelAndView mv = new ModelAndView("administrativo/fornecedores/lista");
    mv.addObject("listaFornecedores",fornecedorRepositorio.findAll());
    return mv;
  }

  @PostMapping("/salvarFornecedor")
  public ModelAndView salvar(Fornecedor fornecedor, BindingResult result){
    if(result.hasErrors()){
      return cadastrar(fornecedor);
    }
    //salva o fornecedor
    fornecedorRepositorio.saveAndFlush(fornecedor);
    //e em seguida retorna para salvar um novo fornecedor
    return cadastrar(new Fornecedor());
  }
}