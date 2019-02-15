package br.com.app.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.app.model.db.fruta.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}