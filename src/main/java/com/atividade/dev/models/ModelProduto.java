package com.atividade.dev.models;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ModelProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser nulo")// Para string o notnull parece nao funcionar como para tipos numéricos
	private String nome;
	@NotNull(message = "Valor não pode ser nulo")
	private double valor;
	@NotNull(message = "Marca não pode ser nulo")
	@ManyToOne
	
	private ModelMarca marca;
	public ModelProduto() {
		super();
	}
	public ModelProduto(Long id, String nome, double valor, ModelMarca marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.marca = marca;
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setValor(String valor) {
		this.valor = Float.valueOf(valor);
	}
	public ModelMarca getMarca() {
		return marca;
	}
	public void setMarca(ModelMarca marca) {
		this.marca = marca;
	}

}
