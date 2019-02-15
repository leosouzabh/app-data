package br.com.app.model.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.app.model.db.fruta.Movimento;
import br.com.app.model.db.fruta.Produto;

public class MovimentoForm {

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	private Movimento movimentoView;
	
	
	private List<Produto> produtos;
	private List<MovimentoItemForm> itensMovimento;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Movimento getMovimentoView() {
		return movimentoView;
	}

	public void setMovimentoView(Movimento movimentoView) {
		this.movimentoView = movimentoView;
	}

	public List<MovimentoItemForm> getItensMovimento() {
		return itensMovimento;
	}

	public void setItensMovimento(List<MovimentoItemForm> itensMovimento) {
		this.itensMovimento = itensMovimento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
