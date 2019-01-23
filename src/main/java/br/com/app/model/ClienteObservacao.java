package br.com.app.model;

public class ClienteObservacao {
	private String cliente;
	private String observacao;
	public ClienteObservacao(String cliente, String observacao) {
		this.cliente = cliente;
		this.observacao = observacao;
		
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}