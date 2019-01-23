package br.com.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.app.model.db.fruta.RegraPreco;
import br.com.app.repository.RegraPrecoRepository;

@Component
public class RegraPrecoService extends BaseService {

	private RegraPrecoRepository regraPrecoRepository;


	public RegraPrecoService(RegraPrecoRepository regraPrecoRepository) {
		this.regraPrecoRepository = regraPrecoRepository;
	}

	public List<RegraPreco> findAll() {
		return (List<RegraPreco>) regraPrecoRepository.findAll();
	}

	public RegraPreco save(RegraPreco regra) {
		this.regraPrecoRepository.save(regra);
		return regra;
	}
	
}
