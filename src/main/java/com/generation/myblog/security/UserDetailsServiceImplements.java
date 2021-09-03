package com.generation.myblog.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.myblog.model.Usuario;
import com.generation.myblog.repository.UsuarioRepositorio;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	
	@Autowired
	private UsuarioRepositorio repositorio;

	/**
	 * Metodo utilizado para verificar existencia do usuario no banco e retorna um
	 * UserDetailsImplements com usuario
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repositorio.findByEmail(username);

		if (usuario.isPresent()) {
			return new UserDatailsImplements(usuario.get());
		} else {
			throw new UsernameNotFoundException(username + " not found.");
		}
	}
}