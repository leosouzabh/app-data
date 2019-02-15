package br.com.app.model.db.fruta;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.app.util.AppUtil;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -2909823590887804277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String descricao;

	@NotNull
	private Double precoBase;

	public Long getId() {
		return id;
	}

	public Produto setId(Long id) {
		this.id = id;
		return this;
	}

	public String getDescricao() {
		return descricao;
	}

	public Produto setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public Double getPrecoBase() {
		return precoBase;
	}

	public Produto setPrecoBase(Double precoBase) {
		this.precoBase = precoBase;
		return this;
	}
	
	public String getPrecoBaseStr() {
		if ( this.precoBase != null ) {
			return AppUtil.toString(precoBase);
		} else {
			return null;
		}
	}
	
	
	
}
