package com.atividade.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.dev.models.ModelProduto;

public interface RepositoryProduto extends JpaRepository<ModelProduto, Long>{

}
