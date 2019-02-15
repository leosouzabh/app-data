package br.com.app.model.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.app.model.db.fruta.Empresa;
import br.com.app.model.db.fruta.Produto;

public class UsuarioForm {

	private Long id;

	@NotEmpty @NotNull
	private String nome;
	
	@NotEmpty @NotNull
	private String email;

	public Long getId() {
		return id;
	}

	public UsuarioForm setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public UsuarioForm setNome(String nome) {
		this.nome = nome;
		return this;
	}


	public String getEmail() {
		return email;
	}

	public UsuarioForm setEmail(String email) {
		this.email = email;
		return this;
	}
	
	
}
