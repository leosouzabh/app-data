package br.com.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.model.db.fruta.Cliente;
import br.com.app.model.db.fruta.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	@Modifying
	@Transactional(propagation=Propagation.REQUIRED)
	@Query("delete from Pedido p where p.cliente = ?1")
    void deletePedidoByCliente(Cliente cliente);
	
}