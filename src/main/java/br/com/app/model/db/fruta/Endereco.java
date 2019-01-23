package br.com.app.model.db.fruta;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -2118757825058658694L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String logradouro;
	
	@NotNull
	private String barro;
	
	@NotNull
	private String numero;

	public Long getId() {
		return id;
	}

	public Endereco setId(Long id) {
		this.id = id;
		return this;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Endereco setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public String getBarro() {
		return barro;
	}

	public Endereco setBarro(String barro) {
		this.barro = barro;
		return this;
	}

	public String getNumero() {
		return numero;
	}

	public Endereco setNumero(String numero) {
		this.numero = numero;
		return this;
	}
	
	
}
