package br.com.app.model.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "INPUT")
public class Input {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	private String configuracao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="OWNER_ID")
	private Owner owner;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PROJETO_ID")
	private Projeto projeto;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name = "TAG_INPUT", 
		joinColumns = { @JoinColumn(name = "INPUT_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "PROJECT_ID") }
	)
	private Set<Tag> tags = new HashSet<>();

	public enum Tipo {
		NOVO,
		ENTREGUE,
		CANCELADO
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

	public String getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(String configuracao) {
		this.configuracao = configuracao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	
	
	

}
