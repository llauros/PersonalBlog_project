package com.generation.myblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.myblog.model.Postagem;

@Repository
public interface PostagemRepositorio extends JpaRepository<Postagem, Long> {

	/**
	 * Metodo utilizado para pesquisar coluna titulo da tabela postagem
	 * 
	 * @param titulo
	 * @return Lista de Postagens
	 * @since 1.0
	 * @author Lucas Lauro
	 */
	List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}