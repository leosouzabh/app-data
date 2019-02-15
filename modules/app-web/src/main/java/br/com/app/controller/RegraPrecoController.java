package br.com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.app.model.form.RegraPrecoForm;
import br.com.app.security.auth.UsuarioLogado;
import br.com.app.service.ClienteService;
import br.com.app.service.EmpresaService;
import br.com.app.service.ProdutoService;
import br.com.app.service.RegraPrecoService;

@Controller
@RequestMapping("/regraPreco")
public class RegraPrecoController extends BaseController {

	private ClienteService clienteService;
	private ProdutoService produtoService;
	private EmpresaService empresaService;
	
	private RegraPrecoService regraPrecoService;

	public RegraPrecoController(ClienteService clienteService, ProdutoService produtoService,
			EmpresaService empresaService, RegraPrecoService regraPrecoService) {
		this.clienteService = clienteService;
		this.produtoService = produtoService;
		this.empresaService = empresaService;
		this.regraPrecoService = regraPrecoService;
	}
	

	@Secured("ROLE_ADMIN")
	@GetMapping({"", "/", "/index"})
	public String list(Model model, UsuarioLogado usuario) {
		model.addAttribute(LISTAGEM, this.regraPrecoService.findAll());
		return "regraPreco/list";
	}
	
	


	@Secured({"ROLE_ADMIN"})
	@GetMapping("/novo")
	public String novo(RegraPrecoForm form, HttpServletRequest request) {
		montaCombos(form);
		return "regraPreco/novo";
	}

	private void montaCombos(RegraPrecoForm form) {
		form.setProdutos(this.produtoService.findAll());
		form.setEmpresas(this.empresaService.findAll());
		form.setClientes(this.clienteService.findAll());
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/salvar")
	public String salvar(@Valid RegraPrecoForm form, BindingResult result, Model model, RedirectAttributes redir, HttpServletRequest request) {
		if ( result.hasErrors() ) {
			montaCombos(form);
			return "regraPreco/novo";
		}
	
		this.regraPrecoService.save(form.getRegraPreco());
		sucessoRegistroSalvo(redir);
		return "redirect:index";
			
	}
	
	/*
	@Secured("ROLE_ADMIN")
	@GetMapping({"/view/{id}"})
	public String view(MovimentoForm form, @PathVariable("id") long id, Model model) {
		Movimento viewObject = movimentoService.loadMovimento(id);
		
		MovimentoView view = new MovimentoView();
		for (MovimentoItem movimentoItem : viewObject.getItens()) {
			String descricaoProduto = movimentoItem.getProduto().getDescricao();
			String obsPedido = movimentoItem.getObservacao();
			view.addQuantidade(descricaoProduto);
			if ( StringUtils.isNotEmpty(obsPedido) ) {
				view.addObservacao(descricaoProduto, obsPedido);
			}
		}
		
		model.addAttribute("movimento", view); 
		
		
		form.setMovimentoView(viewObject);
		return "movimento/view";
	}
	*/

	
	
	
}
