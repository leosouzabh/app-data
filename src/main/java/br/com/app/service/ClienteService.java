package br.com.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.model.db.fruta.Cliente;
import br.com.app.model.db.fruta.Pedido;
import br.com.app.model.db.fruta.PedidoItem;
import br.com.app.model.form.UsuarioForm;
import br.com.app.model.form.PedidoItemForm;
import br.com.app.repository.ClienteRepository;
import br.com.app.repository.PedidoRepository;
import br.com.app.repository.ProdutoRepository;
import br.com.app.util.AppUtil;

@Component
public class ClienteService extends BaseService {

	private ClienteRepository clienteRepository;
	private PedidoRepository pedidoRepository;
	private ProdutoRepository produtoRepository;

	public ClienteService(ClienteRepository clienteRepository, PedidoRepository pedidoRepository, 
			ProdutoRepository produtoRepository ) {
		this.clienteRepository = clienteRepository;
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
	}

	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void saveUpdateCliente(UsuarioForm form) {
		Cliente cliente = saveCliente(form);
		savePedido(form, cliente);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	private void savePedido(UsuarioForm form, Cliente cliente) {
		
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	private Cliente saveCliente(UsuarioForm form) {
		return null;
	}
	
}
