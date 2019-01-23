package br.com.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.app.model.db.fruta.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	List<Usuario> findAllByNome(String nome);
	List<Usuario> findOneByEmail(String email);
	
}