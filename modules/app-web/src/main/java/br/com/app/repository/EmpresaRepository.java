package br.com.app.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.app.model.db.fruta.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

}