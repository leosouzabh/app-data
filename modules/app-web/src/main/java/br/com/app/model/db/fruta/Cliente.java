package br.com.app.model.db.fruta;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = -2909823590887804277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	private String telefone;
	
	private String email;

	@NotNull
	@ManyToOne
	@JoinColumn(name="EMPRESA_ID")
	private Empresa empresa;

	public Long getId() {
		return id;
	}

	public Cliente setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Cliente setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getTelefone() {
		return telefone;
	}

	public Cliente setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Cliente setEmail(String email) {
		this.email = email;
		return this;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public Cliente setEmpresa(Empresa empresa) {
		this.empresa = empresa;
		return this;
	}
	
	public String getEmpresaNome() {
		return String.format("(%s) %s", this.empresa.getNome(), this.nome);
	}


}
