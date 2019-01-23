package br.com.app.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.app.model.db.fruta.Ausencia;

public interface AusenciaRepository extends CrudRepository<Ausencia, Long> {

}