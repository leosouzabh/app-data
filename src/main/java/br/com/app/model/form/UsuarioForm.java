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
	private String senha;
	
	@NotEmpty @NotNull
	private String email;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
