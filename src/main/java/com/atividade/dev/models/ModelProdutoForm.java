package com.atividade.dev.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Entity
public class ModelProdutoForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@NotNull(message = "Nome não pode ser nulo")
	private String nome;
	@NotNull(message = "Valor não pode ser nulo")
	private String valor;
	@NotNull(message = "Marca não pode ser nulo")
	private String marca;
	public ModelProdutoForm() {
		super();
	}
	public ModelProdutoForm(String id, String nome, String valor, String marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.marca = marca;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public @NotNull(message = "Marca não pode ser nulo") String getMarca() {
		return marca;
	}
	public void setMarca( String marca) {
		this.marca = marca;
	}

}
