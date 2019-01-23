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
@Table(name = "EMPRESA")
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = -8818187291141618337L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="ENDERECO_ID")
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public Empresa setId(Long id) {
		this.id = id;
		return this;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Empresa setEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Empresa setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	
		
}
