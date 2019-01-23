package br.com.app.model.db.fruta;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIMENTO_ITEM")
public class MovimentoItem implements Serializable {
	
	private static final long serialVersionUID = -2909823590887804277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String diaSemana;
	
	@NotNull
	private Double preco;
	
	private String observacao;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="MOVIMENTO_ID")
	private Movimento movimento;
	
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PRODUTO_ID")
	private Produto produto;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;

	@NotNull
	private Integer quantidade;
	
	
	public Long getId() {
		return id;
	}

	public MovimentoItem setId(Long id) {
		this.id = id;
		return this;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public MovimentoItem setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
		return this;
	}

	public Double getPreco() {
		return preco;
	}

	public MovimentoItem setPreco(Double preco) {
		this.preco = preco;
		return this;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public MovimentoItem setMovimento(Movimento movimento) {
		this.movimento = movimento;
		return this;
	}

	public Produto getProduto() {
		return produto;
	}

	public MovimentoItem setProduto(Produto produto) {
		this.produto = produto;
		return this;
	}

	public String getObservacao() {
		return observacao;
	}

	public MovimentoItem setObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public MovimentoItem setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public MovimentoItem setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		return this;
	}

	
	 

	
}
