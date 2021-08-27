package com.generation.myblog.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


/**
 * 
 * @author llauro
 *
 *         SpringBootTeste(web) Caso a aplicação esteja rodando na porta pradrão
 *         (porta 8080: Localmente, porta 80: Em produção na web) ela irá
 *         procurar uma outra porta livre devido a opção RANDOM_PORT
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioTest {

	public Usuario usuario;
	public Usuario usuarioNulo = new Usuario();

	/**
	 * Testa todos os atributos da classe
	 * 
	 * Verificar as ANOTAÇÕES que inserimos dentro da classe Usuario Model. Cria uma
	 * lista com as validações. Irá olhar cada atributo (variavel) que foi informado
	 * dentro do objeto.
	 */
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	/**
	 * Caso todos os objetos passem pelas validações, o validator estará vazio.
	 * Só terá algum valor caso alguma anotação não tenha sido respeitada
	 */
	Validator validator = factory.getValidator();
	
	/**
	 * @BeforeEach -> Anotação faz com que o metodo seja executado antes de todos os outro metodos
	 */
	@BeforeEach
	public void start() {
		LocalDate data = LocalDate.parse("2000-07,22", DateTimeFormatter.ofPattern("yyy-MM-dd") );
		usuario = new Usuario(0L, "José da Silva", "zé@email.com.br", "123456789",  data);
	}

	@Test
	void testValidaAtributos() {
		
		/**
		 * violacao irá receber a lista de erros 
		 */
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
	}

}
