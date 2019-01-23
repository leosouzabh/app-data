package br.com.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.app.model.db.fruta.Usuario;
import br.com.app.model.form.UsuarioForm;
import br.com.app.repository.UsuarioRepository;
import br.com.app.security.auth.UsuarioLogado;

@Component
public class UsuarioService extends BaseService {

	private UsuarioRepository usuarioRepository;
	private MailService mailService;
	
	public UsuarioService(UsuarioRepository usuarioRepository, MailService mailService) {
		this.usuarioRepository = usuarioRepository;
		this.mailService = mailService;
	}

	public void salvar(UsuarioForm form) {
		// TODO Auto-generated method stub
		
	}

	public Usuario load(UsuarioLogado token) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Usuario> list() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	
	
	

}