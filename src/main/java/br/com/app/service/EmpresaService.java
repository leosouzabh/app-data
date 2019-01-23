package br.com.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.app.model.db.fruta.Empresa;
import br.com.app.repository.EmpresaRepository;

@Component
public class EmpresaService extends BaseService {

	private EmpresaRepository empresaRepository;


	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public List<Empresa> findAll() {
		return (List<Empresa>) empresaRepository.findAll();
	}

}
