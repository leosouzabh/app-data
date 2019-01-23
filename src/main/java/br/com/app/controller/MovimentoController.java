package br.com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.app.model.ClienteObservacao;
import br.com.app.model.LabelValue;
import br.com.app.model.MovimentoView;
import br.com.app.model.db.fruta.Movimento;
import br.com.app.model.db.fruta.MovimentoItem;
import br.com.app.model.form.MovimentoForm;
import br.com.app.model.form.MovimentoItemForm;
import br.com.app.security.auth.UsuarioLogado;
import br.com.app.service.MovimentoService;
import br.com.app.service.ProdutoService;

@Controller
@RequestMapping("/movimento")
public class MovimentoController extends BaseController {


	private MovimentoService movimentoService;
	private ProdutoService produtoService;


	public MovimentoController(MovimentoService movimentoService, ProdutoService produtoService) {
		this.movimentoService = movimentoService;
		this.produtoService = produtoService;
	}


	@Secured("ROLE_ADMIN")
	@GetMapping({"", "/", "/index"})
	public String list(Model model, UsuarioLogado usuario) {
		model.addAttribute(LISTAGEM, this.movimentoService.findAll());
		return "movimento/list";
	}


	@Secured({"ROLE_ADMIN"})
	@GetMapping("/novo")
	public String novo(MovimentoForm form, HttpServletRequest request) {
		//Date date = DataBrUtils.toDate("05/12/2016");
		//form.setData(date);
		
		//form.setProdutos(this.produtoService.findAll());
		//List<MovimentoItemForm> listaItens = movimentoService.criaListaMovimentoItem(form);
		//form.setItensMovimento(listaItens);
		
		return "movimento/data";
	}

	@Secured({"ROLE_ADMIN"})
	@PostMapping("/salvar")
	public String salvar(@Valid MovimentoForm form, BindingResult result, Model model, RedirectAttributes redir, HttpServletRequest request) {
		if ( result.hasErrors() ) {
			return "movimento/novo";
		}

		movimentoService.novoMovimento(form);
		sucessoRegistroSalvo(redir);
		return "redirect:index";

	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/adicionarData")
	public String adicionarData(@Valid MovimentoForm form, BindingResult result, Model model, RedirectAttributes redir, HttpServletRequest request) {
		if ( result.hasErrors() ) {
			return "movimento/data";
		}
		
		form.setProdutos(this.produtoService.findAll());
		List<MovimentoItemForm> listaItens = movimentoService.criaListaMovimentoItem(form);
		form.setItensMovimento(listaItens);
		
		return "movimento/adicionarData";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping({"/view/{id}"})
	public String view(MovimentoForm form, @PathVariable("id") long id, Model model) {
		Movimento movimentoObj = movimentoService.loadMovimento(id);

		MovimentoView view = montaObjetoView(movimentoObj);

		model.addAttribute("movimento", view); 

		form.setMovimentoView(movimentoObj);
		return "movimento/view";
	}


	private MovimentoView montaObjetoView(Movimento movimentoObj) {
		MovimentoView view = new MovimentoView();
		processaObservacoes(movimentoObj, view);
		processaAgrupamento(movimentoObj, view);
		return view;
	}


	private void processaAgrupamento(Movimento movimentoObj, MovimentoView view) {


		for (String produto : view.getObservacoes().keySet()) {

			List<LabelValue> lista = new ArrayList<>();
			for (ClienteObservacao cliObs : view.getObservacoes().get(produto)) {

				Optional<LabelValue> findFirst = lista.stream().filter( v ->  v.getLabel().equals(cliObs.getObservacao()) ).findFirst();
				if ( findFirst.isPresent() ) {
					findFirst.get().addValue();
				} else {
					lista.add(new LabelValue(cliObs.getObservacao(), 1));
				}
			}
			view.getAgrupadores().put(produto, lista);
		}

	}


	private void processaObservacoes(Movimento movimentoObj, MovimentoView view) {
		for (MovimentoItem movimentoItem : movimentoObj.getItens()) {
			String descricaoProduto = movimentoItem.getProduto().getDescricao();
			String obsPedido = movimentoItem.getObservacao();
			view.addQuantidade(descricaoProduto);
			if ( StringUtils.isNotEmpty(obsPedido) ) {
				String cliente = String.format("%s (%s)", movimentoItem.getCliente().getNome(), movimentoItem.getCliente().getEmpresa().getNome()); 
				view.addObservacao(descricaoProduto, cliente, obsPedido);
			}
		}
	}

}

