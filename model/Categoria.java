package com.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String tipo;
	
	@Size(min = 1, max = 100)
	private String descricao;
	
	@OneToMany(mappedBy = "categoria" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;


	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
