package br.com.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovimentoView {
	
	private Map<String, Integer> quantidades;
	private Map<String, List<ClienteObservacao>> observacoes;
	
	private Map<String, List<LabelValue>> agrupadores;
	
	public MovimentoView() {
		this.quantidades = new HashMap<>();
		this.observacoes = new HashMap<>();
		this.agrupadores = new HashMap<>();
	}

	public void addQuantidade(String descricao) {
		Integer qtde = quantidades.get(descricao);

		qtde = qtde == null ? 1 : qtde+1; 
		quantidades.put(descricao, qtde);
	}
	
	public void addObservacao(String produto, String nomeCliente, String observacao) {
		List<ClienteObservacao> obs = observacoes.get(produto);

		if (obs == null) {
			obs = new ArrayList<>();
		}
		obs.add(new ClienteObservacao(nomeCliente, observacao) );
		observacoes.put(produto, obs);
	}
	
	public Map<String, Integer> getQuantidades() {
		return quantidades;
	}
	public Map<String, List<ClienteObservacao>> getObservacoes() {
		return observacoes;
	}

	public Map<String, List<LabelValue>> getAgrupadores() {
		return agrupadores;
	}
	
}

