package com.atividade.dev.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
public class ModelMarca {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Nome não pode estar em branco!")
	@NotNull(message = "Nome não pode estar em branco!")
	private String nome;

	public ModelMarca(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public ModelMarca() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
