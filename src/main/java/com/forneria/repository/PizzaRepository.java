package com.forneria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.forneria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

	public List<Pizza> findAllBySaborContainingIgnoreCase(@Param("sabor") String sabor);
	public List<Pizza> findByTipoNomeIgnoreCase(@Param("nome") String nome);

}