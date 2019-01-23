package br.com.app.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.app.model.db.fruta.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

}