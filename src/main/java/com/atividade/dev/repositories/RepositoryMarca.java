package com.atividade.dev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.dev.models.ModelMarca;

public interface RepositoryMarca extends JpaRepository<ModelMarca, Long>{
	
	 List<ModelMarca> findByNomeLike(String nome);
	

}
