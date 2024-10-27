package com.example.sistema.controller;

import com.example.sistema.model.Cliente;
import com.example.sistema.repositories.CidadeRepositorio;
import com.example.sistema.repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ClienteControle {

  @Autowired
  private ClienteRepositorio clienteRepositorio;

  @Autowired
  private CidadeRepositorio cidadeRepositorio;

  @GetMapping("/cadastroCliente")
  public ModelAndView cadastrar(Cliente cliente){
    ModelAndView mv = new ModelAndView("administrativo/clientes/cadastro");
    mv.addObject("cliente",cliente);
    mv.addObject("listaCidades",cidadeRepositorio.findAll());
    return mv;
  }

  //Recebemos o parâmetro
  @GetMapping("/editarCliente/{id}")
  public ModelAndView editar(@PathVariable("id") Long id){
    Optional<Cliente> cliente = clienteRepositorio.findById(id);
    return cadastrar(cliente.get());
  }

  //Recebemos o parâmetro
  @GetMapping("/removerCliente/{id}")
  public ModelAndView remover(@PathVariable("id") Long id){
    Optional<Cliente> cliente = clienteRepositorio.findById(id);
    clienteRepositorio.delete(cliente.get());
    return listar();
  }

  @GetMapping("/listarCliente")
  public ModelAndView listar(){
    ModelAndView mv = new ModelAndView("administrativo/clientes/lista");
    mv.addObject("listaClientes",clienteRepositorio.findAll());
    return mv;
  }

  @PostMapping("/salvarCliente")
  public ModelAndView salvar(Cliente cliente, BindingResult result){
    if(result.hasErrors()){
      return cadastrar(cliente);
    }
    //salva o cliente
    clienteRepositorio.saveAndFlush(cliente);
    //e em seguida retorna para salvar um novo cliente
    return cadastrar(new Cliente());
  }
}