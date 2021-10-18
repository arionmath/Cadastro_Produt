package com.atividade.dev.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.dev.models.ModelMarca;
import com.atividade.dev.models.ModelProduto;
import com.atividade.dev.repositories.RepositoryMarca;
@Service
public class MarcaService {
	
	@Autowired
	RepositoryMarca RM;
	
	public void salvaMarca(ModelMarca marca ){
		RM.save(marca);
	}

	public Object Listar() {
		// TODO Auto-generated method stub
		System.out.println("listagem de marca srvice com n = "+ RM.count());
		
		return RM.findAll();
	}

	public Object ListarNomes() {
		List<ModelMarca> lista =  RM.findAll();
		ArrayList< String > listanome =  new ArrayList<>();
		for (ModelMarca modelMarca : lista) {
			listanome.add( modelMarca.getNome() );
			System.out.println("nome = "+modelMarca.getNome());
		
	} return lista;

	}

	public Object procurarPor(String busca) {
		return RM.findByNomeContaining(busca);
		
	}
}
