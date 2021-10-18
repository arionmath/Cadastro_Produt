package com.atividade.dev.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atividade.dev.models.ModelProduto;
import com.atividade.dev.service.MarcaService;
import com.atividade.dev.service.ProdutoService;

@Controller
public class ControllerProduto {
	
	@Autowired
	ProdutoService produtoService;
	@Autowired
	MarcaService marcaService;

	
	@GetMapping("/produto/listar")
	public ModelAndView listarProdutos(@PathParam(value = "busca") String busca) {// usar o mesmo nome do parametro e argumento
		System.out.println("\nTermo para busca = "+busca+"\n");
			
		
		ModelAndView mav = new ModelAndView("listagemProduto");
		if (!(busca == null)) {
			mav.addObject("produtos",produtoService.procurarPor(busca));
			
		}else {		
		mav.addObject("produtos", produtoService.ListarNomes());
		}
		return mav;
	}

	
	
	@GetMapping("/produto/cadastro")
	public ModelAndView salvaProdutoView() {
		ModelAndView mav = new ModelAndView("cadastroProduto");
		
		mav.addObject("marcas", marcaService.ListarNomes());
		return mav;
	}
	@PostMapping("/produto/cadastro")
	public ModelAndView salvaProdutoPost(@Valid ModelProduto produto,BindingResult bindingResult) {
		
		System.out.println("Produto recebido:"
				+"produto" +produto.toString()
				+"\nNome  "+produto.getNome()
				+"\nvalor "+ produto.getValor()
				+"\nmarca "+ produto.getMarca()
				+"\nid    "+produto.getId());
		
			
		
		
		if (bindingResult.hasErrors()) {
			System.out.println("Erros");
			List<ObjectError> erros = bindingResult.getAllErrors();
			List<String> errosString = new ArrayList<String>();
			
			for (ObjectError objerror : erros) {
				errosString.add( objerror.getDefaultMessage());
			}
			ModelAndView mav = new ModelAndView("cadastroProduto.html");
			mav.addObject("mensagem", errosString);
			mav.addObject("marcas", marcaService.ListarNomes());
			return mav;
		}
		ModelAndView mav = new ModelAndView("cadastroProduto.html");
		produtoService.salvaProduto(produto);
		mav.addObject("marcas", marcaService.ListarNomes());
		return mav;
		
	}

}
