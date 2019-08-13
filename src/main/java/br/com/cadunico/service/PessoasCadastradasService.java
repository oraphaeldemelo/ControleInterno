package br.com.cadunico.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.cadunico.model.Usuario;
import br.com.cadunico.repository.UsuarioRepository;

public class PessoasCadastradasService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository repositorio;
	
	public List<Usuario> porCodFamiliar(Long codigo){
		return repositorio.porCodFamiliar(codigo);
	}
	
	public void excluir(Usuario u) throws NegocioException{
		repositorio.excluirUsuario(u);
	}
}
