package br.com.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.app.model.db.fruta.Cliente;
import br.com.app.repository.ClienteRepository;

@Component
public class FrutaService extends BaseService {

	private ClienteRepository clienteRepository;

	public FrutaService(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}


	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}
	
		
	
	
	
}
