package br.com.app.model.db.fruta;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIMENTO")
public class Movimento implements Serializable {
	
	private static final long serialVersionUID = -2909823590887804277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Date data;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(mappedBy = "movimento", cascade = CascadeType.ALL)
	private Set<MovimentoItem> itens;
	
	public enum Status {
	    NOVO,
	    ENTREGUE,
	    CANCELADO
	}

	public Long getId() {
		return id;
	}

	public Movimento setId(Long id) {
		this.id = id;
		return this;
	}

	public Date getData() {
		return data;
	}

	public Movimento setData(Date data) {
		this.data = data;
		return this;
	}

	public Set<MovimentoItem> getItens() {
		return itens;
		
	}

	public Movimento setItens(Set<MovimentoItem> itens) {
		this.itens = itens;
		return this;
	}

	public Status getStatus() {
		return status;
	}

	public Movimento setStatus(Status status) {
		this.status = status;
		return this;
	}

	
	
	
}
