package br.com.app.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Component;

import br.com.app.model.db.fruta.Movimento;
import br.com.app.model.db.fruta.MovimentoItem;
import br.com.app.model.db.fruta.PedidoItem;
import br.com.app.model.form.MovimentoForm;
import br.com.app.model.form.MovimentoItemForm;
import br.com.app.repository.MovimentoRepository;

@Component
public class MovimentoService extends BaseService {

	private MovimentoRepository movimentoRepository;
	private PedidoService pedidoService;
	
	
	public MovimentoService(MovimentoRepository movimentoRepository, PedidoService pedidoService) {
		this.movimentoRepository = movimentoRepository;
		this.pedidoService = pedidoService;
	}


	public List<Movimento> findAll() {
		return (List<Movimento>) this.movimentoRepository.findAll();
	}

	public List<MovimentoItemForm> criaListaMovimentoItem(MovimentoForm form){
    	String diaSemanaMovimento = getDiaSemanaMovimento(form.getData());
    	List<PedidoItem> pedidosItens = pedidoService.recuperaItensPorDia(diaSemanaMovimento);
    	
    	List<MovimentoItemForm> itens = new ArrayList<>();
    	
    	for (PedidoItem pedidoItem : pedidosItens) {
    		itens.add(new MovimentoItemForm()
    				.setObservacao(pedidoItem.getObservacao())
    				.setPreco(pedidoItem.getPreco())
    				.setProduto(pedidoItem.getProduto())
    				.setCliente(pedidoItem.getPedido().getCliente())
    				.setQuantidade(pedidoItem.getQuantidade()));
		}
    	
    	return itens;

	}

	public void novoMovimento(MovimentoForm form) {
    	
    	String diaSemanaMovimento = getDiaSemanaMovimento(form.getData());
		List<PedidoItem> pedidosItens = pedidoService.recuperaItensPorDia(diaSemanaMovimento);
    	
		Movimento movimento = new Movimento()
    			.setData(form.getData())
    			.setStatus(Movimento.Status.NOVO);
    	preencheMovimentoItens(movimento, diaSemanaMovimento, pedidosItens);
    	
    	this.movimentoRepository.save(movimento);
	}


	private void preencheMovimentoItens(Movimento movimento, String diaSemanaMovimento, List<PedidoItem> pedidosItens) {
		
    	Set<MovimentoItem> movimentoItens = new HashSet<>();
    	
    	for (PedidoItem pedidoItem : pedidosItens) {
    		movimentoItens.add(new MovimentoItem()
    				.setDiaSemana(diaSemanaMovimento)
    				.setObservacao(pedidoItem.getObservacao())
    				.setPreco(pedidoItem.getPreco())
    				.setProduto(pedidoItem.getProduto())
    				.setCliente(pedidoItem.getPedido().getCliente())
    				.setMovimento(movimento)
    				.setQuantidade(pedidoItem.getQuantidade()));
		}
    	movimento.setItens(movimentoItens);
	}
	
		
	
	public static String getDiaSemanaMovimento(Date data) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(data);
		
		Map<Integer, String> dias = new HashedMap<>();
		dias.put(Calendar.MONDAY, PedidoItem.DIA_SEGUNDA);
		dias.put(Calendar.TUESDAY, PedidoItem.DIA_TERCA);
		dias.put(Calendar.WEDNESDAY, PedidoItem.DIA_QUARTA);
		dias.put(Calendar.THURSDAY, PedidoItem.DIA_QUINTA);
		dias.put(Calendar.FRIDAY, PedidoItem.DIA_SEXTA);
		dias.put(Calendar.SATURDAY, PedidoItem.DIA_SABADO);
		dias.put(Calendar.SUNDAY, PedidoItem.DIA_DOMING);
		
		return dias.get(calendar.get(Calendar.DAY_OF_WEEK));
	}


	public Movimento loadMovimento(long id) {
		return movimentoRepository.findOne(id);
	}
	
}
