package br.com.app.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.app.model.db.fruta.Movimento;

public interface MovimentoRepository extends CrudRepository<Movimento, Long> {

}