package br.com.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.app.model.db.fruta.PedidoItem;

public interface PedidoItemRepository extends CrudRepository<PedidoItem, Long> {

	List<PedidoItem> findAllByDiaSemana(String diaSemana);
	
}