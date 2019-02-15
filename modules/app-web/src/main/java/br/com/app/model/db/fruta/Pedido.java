package br.com.app.model.db.fruta;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = -2909823590887804277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull @ManyToOne	
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Set<PedidoItem> itens;

	public Pedido() {
		
	}
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public Pedido setId(Long id) {
		this.id = id;
		return this;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public Pedido setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public Set<PedidoItem> getItens() {
		return itens;
	}

	public Pedido setItens(Set<PedidoItem> itens) {
		this.itens = itens;
		return this;
	}



}
