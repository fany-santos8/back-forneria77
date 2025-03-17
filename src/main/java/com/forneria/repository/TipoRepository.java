package com.forneria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.forneria.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long>{
	
	public List<Tipo> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}