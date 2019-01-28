package br.com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.app.model.MensagemView;

public class BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	protected String LISTAGEM = "listagem";
	
	 @Autowired
	 private MessageSource messageSource;
	
	protected  boolean hasAuth(String role) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		log.info(auth.getPrincipal().toString());
		log.info(auth.getAuthorities().toString() );
		
		return auth.getAuthorities().contains(new SimpleGrantedAuthority(role) );
	} 
	
	
	protected void sucessoRegistroSalvo(RedirectAttributes redir) {
		redir.addFlashAttribute("mensagem", MensagemView.buildSucesso(getMessage("msg.sucesso.registro.salvo")));
	}


	private String getMessage(String key) {
		return messageSource.getMessage(key, null, null);
	}

	protected void erroRegistroExistente(Model model) {
		erroMsg(model, getMessage("msg.erro.registro.existente"));
	}


	protected void erroMsg(Model model, String msg) {
		addMsg(model, MensagemView.buildErro(msg));
	}
	protected void infoMsg(Model model, String msg) {
		addMsg(model, MensagemView.buildInfo(msg));
	}
	protected void sucessoMsg(Model model, String msg) {
		addMsg(model, MensagemView.buildSucesso(msg));
	}
	
	private void addMsg(Model model, MensagemView msgView) {
		model.addAttribute("mensagem", msgView);
	}
}
