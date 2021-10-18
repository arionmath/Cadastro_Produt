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

import com.atividade.dev.models.ModelMarca;
import com.atividade.dev.service.MarcaService;

@Controller
public class ControllerMarca {

	@Autowired
	MarcaService marcaService;

	@GetMapping("/marca/listar")
	public ModelAndView listarMarca(@PathParam(value = "busca") String busca) {

		ModelAndView mav = new ModelAndView("listagemMarca.html");

		if (busca != null) {
			System.out.println("busca nao nula Recebido a " + busca);
			mav.addObject("marcas", marcaService.procurarPor(busca));
			return mav;
		}

		mav.addObject("marcas", marcaService.Listar());
		return mav;
	}

	@GetMapping("/marca/cadastro")
	public String cadastroMarca() {
		return "cadastroMarca.html";
	}

	@PostMapping("/marca/cadastro")
	public ModelAndView recebimentoMarca(@Valid ModelMarca marca, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Erros");
			List<ObjectError> erros = bindingResult.getAllErrors();
			List<String> errosString = new ArrayList<>();

			for (ObjectError objerror : erros) {
				errosString.add(objerror.getDefaultMessage());
			}
			ModelAndView mav = new ModelAndView("cadastroMarca.html");
			mav.addObject("mensagem", errosString);
			return mav;
		}

		marcaService.salvaMarca(marca);
		return new ModelAndView("cadastroMarca.html").addObject("mensagem", "Marca salva com sucesso!");
	}

}
