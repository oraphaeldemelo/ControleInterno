package br.com.cadunico.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.cadunico.model.Usuario;
import br.com.cadunico.repository.CadastroUsuarioRepository;
import br.com.cadunico.repository.ControlePastasRepository;
import br.com.cadunico.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroUsuarioRepository repositorio;

	@Inject
	private ControlePastasRepository repositorioPasta;

	@Transactional
	public Usuario salvar(Usuario usuario) throws NegocioException {
		Usuario usuarioSelecionado = repositorio.porNis(usuario.getNis());
		

		if (usuarioSelecionado != null && !usuarioSelecionado.equals(usuario)) {
			throw new NegocioException("Já existe um Usuario com o mesmo NIS");
		}
		
		return repositorio.salvar(usuario);
	}

	public Usuario porCodFamiliar(Long u1) {
		Usuario u = repositorio.porCodFamiliar(u1);

		return u;
	}

}
