package br.com.app.model.db.fruta;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;

import br.com.app.util.AppUtil;

@Entity
@Table(name = "REGRA_PRECO")
public class RegraPreco implements Serializable {
	
	private static final long serialVersionUID = -2909823590887804277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="EMPRESA_ID")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;
	
	@NotNull @ManyToOne
	@JoinColumn(name="PRODUTO_ID")
	private Produto produto;
	
	@NotNull
	private Double preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	public String getPrecoStr() {
		return preco != null ? AppUtil.toString(this.preco) : null;
	}

	public void setPrecoStr(String precoStr) {
		if ( StringUtils.isNotEmpty(precoStr) ) {
			setPreco( AppUtil.toDouble(precoStr) );
		}
	}

	
}
