package com.atividade.dev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atividade.dev.models.ModelProduto;

public interface RepositoryProduto extends JpaRepository<ModelProduto, Long>{
	
//	@Query(value = "select mp from model_produto mp")
	List<ModelProduto> findByNomeContaining(String nome);

}
