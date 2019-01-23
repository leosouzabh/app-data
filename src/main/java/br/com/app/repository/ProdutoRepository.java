package br.com.app.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.app.model.db.fruta.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}