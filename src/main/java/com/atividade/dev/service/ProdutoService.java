package com.atividade.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.dev.models.ModelProduto;
import com.atividade.dev.repositories.RepositoryProduto;

@Service
public class ProdutoService {
	@Autowired
	RepositoryProduto RP;
	
	public void salvaProduto(ModelProduto produto ){
		
		
		System.out.println("produto salva: "+produto.getNome()+produto.getId());
		
	}

	public Object ListarNomes() {
		System.out.println("Listagem de produto com "+RP.count()+" Unidades");
		// TODO Auto-generated method stubmarcas
		List< ModelProduto > lista =  RP.findAll();
//		ArrayList< String > listanome =  new ArrayList<>();
//		for (ModelProduto modelProduto : lista) {
//			listanome.add( modelProduto.getNome() );
//			System.out.println("nome = "+modelProduto.getNome());
//			
//		}
		return lista;
	}

	

}
