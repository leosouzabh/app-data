package br.com.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.app.model.db.fruta.PedidoItem;
import br.com.app.repository.PedidoItemRepository;

@Component
public class PedidoService extends BaseService {

	private PedidoItemRepository pedidoItemRepository;
	
	public PedidoService(PedidoItemRepository pedidoItemRepository) {
		this.pedidoItemRepository = pedidoItemRepository;
	}


	public List<PedidoItem> recuperaItensPorDia(String diaSemanaMovimento) {
		return pedidoItemRepository.findAllByDiaSemana(diaSemanaMovimento);
	}
	
		
	
	
	
}
