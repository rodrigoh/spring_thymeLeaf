package com.example.sistema.controller;

import com.example.sistema.model.Estado;
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
public class EstadoControle {

  @Autowired
  private EstadoRepositorio estadoRepositorio;

  @GetMapping("/cadastroEstado")
  public ModelAndView cadastrar(Estado estado){
    ModelAndView mv = new ModelAndView("administrativo/estados/cadastro");
    mv.addObject("estado",estado);
    return mv;
  }

  //Recebemos o parâmetro
  @GetMapping("/editarEstado/{id}")
  public ModelAndView editar(@PathVariable("id") Long id){
    Optional<Estado> estado = estadoRepositorio.findById(id);
    return cadastrar(estado.get());
  }

  //Recebemos o parâmetro
  @GetMapping("/removerEstado/{id}")
  public ModelAndView remover(@PathVariable("id") Long id){
    Optional<Estado> estado = estadoRepositorio.findById(id);
    estadoRepositorio.delete(estado.get());
    return listar();
  }

  @GetMapping("/listarEstado")
  public ModelAndView listar(){
    ModelAndView mv = new ModelAndView("administrativo/estados/lista");
    mv.addObject("listaEstados",estadoRepositorio.findAll());
    return mv;
  }

  @PostMapping("/salvarEstado")
  public ModelAndView salvar(Estado estado, BindingResult result){
    if(result.hasErrors()){
      return cadastrar(estado);
    }
    //salva o estado
    estadoRepositorio.saveAndFlush(estado);
    //e em seguida retorna para salvar um novo estado
    return cadastrar(new Estado());
  }




}
