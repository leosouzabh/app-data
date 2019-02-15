package br.com.app.model.form;

import java.util.List;

import javax.validation.Valid;

import br.com.app.model.db.fruta.Cliente;
import br.com.app.model.db.fruta.Empresa;
import br.com.app.model.db.fruta.Produto;
import br.com.app.model.db.fruta.RegraPreco;


public class RegraPrecoForm {
	private Long id;

	@Valid
	private RegraPreco regraPreco;
	
	private List<Produto> produtos;
	private List<Empresa> empresas;
	private List<Cliente> clientes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RegraPreco getRegraPreco() {
		return regraPreco;
	}
	public void setRegraPreco(RegraPreco regraPreco) {
		this.regraPreco = regraPreco;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
