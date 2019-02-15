package br.com.app.model.form;

import java.io.Serializable;

import br.com.app.model.db.fruta.Cliente;
import br.com.app.model.db.fruta.Produto;
import br.com.app.util.AppUtil;

public class MovimentoItemForm implements Serializable {
	
	private Cliente cliente;
	private Produto produto;
	private Double preco;
	private String observacao;
	private Integer quantidade;
	
	public Cliente getCliente() {
		return cliente;
	}
	public MovimentoItemForm setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	public Produto getProduto() {
		return produto;
	}
	public MovimentoItemForm setProduto(Produto produto) {
		this.produto = produto;
		return this;
	}
	public Double getPreco() {
		return preco;
	}
	public MovimentoItemForm setPreco(Double preco) {
		this.preco = preco;
		return this;
	}
	public String getObservacao() {
		return observacao;
	}
	public MovimentoItemForm setObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public MovimentoItemForm setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		return this;
	}

	public String getPrecoStr() {
		if ( this.preco != null ) {
			return AppUtil.toString(preco);
		} else {
			return null;
		}
	}
	
	
}
