package com.example.sistema.controller;

import com.example.sistema.model.Produto;
import com.example.sistema.repositories.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProdutoControle {

  @Autowired
  private ProdutoRepositorio produtoRepositorio;

  @GetMapping("/cadastroProduto")
  public ModelAndView cadastrar(Produto produto){
    ModelAndView mv = new ModelAndView("administrativo/produtos/cadastro");
    mv.addObject("produto",produto);
    return mv;
  }

  //Recebemos o parâmetro
  @GetMapping("/editarProduto/{id}")
  public ModelAndView editar(@PathVariable("id") Long id){
    Optional<Produto> produto = produtoRepositorio.findById(id);
    return cadastrar(produto.get());
  }

  //Recebemos o parâmetro
  @GetMapping("/removerProduto/{id}")
  public ModelAndView remover(@PathVariable("id") Long id){
    Optional<Produto> produto = produtoRepositorio.findById(id);
    produtoRepositorio.delete(produto.get());
    return listar();
  }

  @GetMapping("/listarProduto")
  public ModelAndView listar(){
    ModelAndView mv = new ModelAndView("administrativo/produtos/lista");
    mv.addObject("listaProdutos",produtoRepositorio.findAll());
    return mv;
  }

  @PostMapping("/salvarProduto")
  public ModelAndView salvar(Produto produto, BindingResult result){
    if(result.hasErrors()){
      return cadastrar(produto);
    }
    //salva o produto
    produtoRepositorio.saveAndFlush(produto);
    //e em seguida retorna para salvar um novo produto
    return cadastrar(new Produto());
  }




}
