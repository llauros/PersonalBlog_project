package com.generation.myblog.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe Modelo para Usuario , a mesma é considerada uma entidade no banco de Dados
 * 
 * @since 1.0
 * @author llauro
 *
 */
@Entity
@Table( name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é Obrigatório!")
	private String nome;

	@NotBlank(message = "O email é obrigatório!")
	@Email(message = "Necessario Email")
	private String email;

	@NotNull(message = "A Senha é Obrigatória!")
	@Size(min = 5, max = 100, message = "Necessario min 5 caracteres")
	private String senha; // Necessarioamente Size deve ser max 100
	
	@Column( name = "dt_nascimento")
	@JsonFormat(pattern = "yyy-MM-dd")
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "criador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"criador"})
	private List<Postagem> minhasPostagens = new ArrayList<>();

	public Usuario() {}

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(Long id, String nome, String email, String senha, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Postagem> getMinhasPostagens() {
		return minhasPostagens;
	}

	public void setMinhasPostagens(List<Postagem> minhasPostagens) {
		this.minhasPostagens = minhasPostagens;
	}

}