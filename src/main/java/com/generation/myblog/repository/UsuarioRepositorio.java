package com.generation.myblog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.myblog.model.Usuario;

/**
 * Interfase utilizada para herdar 
 * 
 * @author Lucas Lauro
 *
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	/**
	 * Metodo utilizado para selecionar apenas um Usuario pelo email (Chave unica)
	 * 
	 * @param email
	 * @return Optional com Usuario unico
	 * @since 1.0
	 * @author Lucas Lauro
	 */
	Optional<Usuario> findByEmail(String email);

	/**
	 * Metodo utilizado para pesquisar coluna nome da tabela Usuario
	 * 
	 * @param nome
	 * @return Lista de Usuario
	 * @since 1.0
	 * @author Lucas Lauro
	 */
	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}