package com.forneria.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipos")
public class Tipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tipo")
	private List<Pizza> pizza;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}

}