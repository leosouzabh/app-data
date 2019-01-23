package br.com.app.model.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.app.model.db.fruta.Movimento;

public class FrutaForm {

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	private Movimento movimentoView;

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
	
	
	
}
