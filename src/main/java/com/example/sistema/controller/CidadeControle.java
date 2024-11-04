package com.example.sistema.controller;

import com.example.sistema.model.Cidade;
import com.example.sistema.repositories.CidadeRepositorio;
import com.example.sistema.repositories.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CidadeControle {

  @Autowired
  private CidadeRepositorio cidadeRepositorio;

  @Autowired
  private EstadoRepositorio estadoRepositorio;

  @GetMapping("/cadastroCidade")
  public ModelAndView cadastrar(Cidade cidade){
    ModelAndView mv = new ModelAndView("administrativo/cidades/cadastro");
    mv.addObject("cidade",cidade);
    mv.addObject("listaEstados",estadoRepositorio.findAll());
    return mv;
  }

  //Recebemos o parâmetro
  @GetMapping("/editarCidade/{id}")
  public ModelAndView editar(@PathVariable("id") Long id){
    Optional<Cidade> cidade = cidadeRepositorio.findById(id);
    return cadastrar(cidade.get());
  }

  //Recebemos o parâmetro
  @GetMapping("/removerCidade/{id}")
  public ModelAndView remover(@PathVariable("id") Long id){
    Optional<Cidade> cidade = cidadeRepositorio.findById(id);
    cidadeRepositorio.delete(cidade.get());
    return listar();
  }

  @GetMapping("/listarCidade")
  public ModelAndView listar(){
    ModelAndView mv = new ModelAndView("administrativo/cidades/lista");
    mv.addObject("listaCidades",cidadeRepositorio.findAll());
    return mv;
  }

  @PostMapping("/salvarCidade")
  public ModelAndView salvar(Cidade cidade, BindingResult result){
    if(result.hasErrors()){
      return cadastrar(cidade);
    }
    //salva a cidade
    cidadeRepositorio.saveAndFlush(cidade);
    //e em seguida retorna para salvar um novo cidade
    return cadastrar(new Cidade());
  }
}