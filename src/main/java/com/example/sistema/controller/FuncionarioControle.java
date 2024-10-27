package com.example.sistema.controller;

import com.example.sistema.model.Funcionario;
import com.example.sistema.repositories.CidadeRepositorio;
import com.example.sistema.repositories.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class FuncionarioControle {

  @Autowired
  private FuncionarioRepositorio funcionarioRepositorio;

  @Autowired
  private CidadeRepositorio cidadeRepositorio;

  @GetMapping("/cadastroFuncionario")
  public ModelAndView cadastrar(Funcionario funcionario){
    ModelAndView mv = new ModelAndView("administrativo/funcionarios/cadastro");
    mv.addObject("funcionario",funcionario);
    mv.addObject("listaCidades",cidadeRepositorio.findAll());
    return mv;
  }

  //Recebemos o parâmetro
  @GetMapping("/editarFuncionario/{id}")
  public ModelAndView editar(@PathVariable("id") Long id){
    Optional<Funcionario> funcionario = funcionarioRepositorio.findById(id);
    return cadastrar(funcionario.get());
  }

  //Recebemos o parâmetro
  @GetMapping("/removerFuncionario/{id}")
  public ModelAndView remover(@PathVariable("id") Long id){
    Optional<Funcionario> funcionario = funcionarioRepositorio.findById(id);
    funcionarioRepositorio.delete(funcionario.get());
    return listar();
  }

  @GetMapping("/listarFuncionario")
  public ModelAndView listar(){
    ModelAndView mv = new ModelAndView("administrativo/funcionarios/lista");
    mv.addObject("listaFuncionarios",funcionarioRepositorio.findAll());
    return mv;
  }

  @PostMapping("/salvarFuncionario")
  public ModelAndView salvar(Funcionario funcionario, BindingResult result){
    if(result.hasErrors()){
      return cadastrar(funcionario);
    }
    //salva o funcionario
    funcionarioRepositorio.saveAndFlush(funcionario);
    //e em seguida retorna para salvar um novo funcionario
    return cadastrar(new Funcionario());
  }
}