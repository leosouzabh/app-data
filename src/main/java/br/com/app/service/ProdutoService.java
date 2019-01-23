package br.com.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.app.model.db.fruta.Produto;
import br.com.app.repository.ProdutoRepository;

@Component
public class ProdutoService extends BaseService {

	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> findAll() {
		return (List<Produto>) produtoRepository.findAll();
	}
	
}
