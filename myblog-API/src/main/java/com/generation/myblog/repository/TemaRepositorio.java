package com.generation.myblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.myblog.model.Tema;

@Repository
public interface TemaRepositorio extends JpaRepository<Tema, Long> {
	
	/**
	 * Metodo utilizado para pesquisar coluna tema da tabela tema
	 * 
	 * @param tema
	 * @return Lista de Tema
	 * @since 1.0
	 * @author Lucas Lauro
	 */
	List<Tema> findAllByTemaContainingIgnoreCase(String tema);
}
