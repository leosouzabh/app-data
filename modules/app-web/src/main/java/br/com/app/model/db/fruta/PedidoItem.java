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
@Table(name = "PEDIDO_ITEM")
public class PedidoItem implements Serializable, Cloneable {
	
	private static final long serialVersionUID = -2909823590887804277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String diaSemana;
	
	private String observacao;
	
	@NotNull
	private Double preco;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="PEDIDO_ID")
	private Pedido pedido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="PRODUTO_ID")
	private Produto produto;
	
	@NotNull
	private Integer quantidade;
	
	public static final String DIA_SEGUNDA = "SEGUNDA_FEIRA";
	public static final String DIA_TERCA = "TERCA_FEIRA";
	public static final String DIA_QUARTA = "QUARTA_FEIRA";
	public static final String DIA_QUINTA = "QUINTA_FEIRA";
	public static final String DIA_SEXTA = "SEXTA_FEIRA";
	public static final String DIA_SABADO = "SABADO";
	public static final String DIA_DOMING = "DOMINGO";
	
	
	public PedidoItem(Produto produto, Double preco, String observacao) {
		this.observacao = observacao;
		this.preco = preco;
		this.produto = produto;
		this.quantidade = 1;
	}
	
	public PedidoItem(Produto produto, Double preco) {
		this.preco = preco;
		this.produto = produto;
		this.quantidade = 1;
	}
	
	public PedidoItem(Produto produto, String observacao) {
		this.observacao = observacao;
		this.preco = produto.getPrecoBase();
		this.produto = produto;
		this.quantidade = 1;
	}
	
	public PedidoItem(Produto produto) {
		this.preco = produto.getPrecoBase();
		this.produto = produto;
		this.quantidade = 1;
	}
	
	public PedidoItem(Produto produto, Integer quantidade) {
		this.preco = produto.getPrecoBase();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public PedidoItem() {
		super();
	}

	public PedidoItem(Produto produto, String dia, Double preco, String observacao, Integer quantidade) {
		this.produto = produto;
		this.diaSemana = dia;
		this.preco = preco;
		this.observacao = observacao;
		this.quantidade = quantidade;
	}

	public PedidoItem(Produto produto, int quantidade, String observacao) {
		this.preco = produto.getPrecoBase();
		this.produto = produto;
		this.quantidade = quantidade;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public PedidoItem setId(Long id) {
		this.id = id;
		return this;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public PedidoItem setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
		return this;
	}

	public Double getPreco() {
		return preco;
	}

	public PedidoItem setPreco(Double preco) {
		this.preco = preco;
		return this;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public PedidoItem setPedido(Pedido pedido) {
		this.pedido = pedido;
		return this;
	}

	public Produto getProduto() {
		return produto;
	}

	public PedidoItem setProduto(Produto produto) {
		this.produto = produto;
		return this;
	}

	public String getObservacao() {
		return observacao;
	}

	public PedidoItem setObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

	
	

	
}
