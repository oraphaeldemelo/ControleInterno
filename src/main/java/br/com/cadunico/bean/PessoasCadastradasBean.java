package br.com.cadunico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadunico.model.Usuario;
import br.com.cadunico.repository.UsuarioRepository;
import br.com.cadunico.service.NegocioException;
import br.com.cadunico.service.PessoasCadastradasService;

@Named
@ViewScoped
public class PessoasCadastradasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoasCadastradasService servico;
	@Inject
	private UsuarioRepository repositorio;

	private Usuario usuarioSelecionado;
	
	private Long pesqCod;
	private String pesqNome;
	private Long pesqNis;

	private List<Usuario> usuarios;

	@PostConstruct
	public void init() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public void excluir() throws NegocioException {
		servico.excluir(usuarioSelecionado);

	}
	
	public void porCodFamiliar(){
		this.usuarios = repositorio.porCodFamiliar(pesqCod);
	}
	
	public void porNome(){
		this.usuarios = repositorio.porNome(pesqNome.toUpperCase());
	}
	
	public void porNis(){
		this.usuarios = repositorio.porNis(pesqNis);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
	public Long getPesqCod() {
		return pesqCod;
	}
	
	public void setPesqCod(Long pesqCod) {
		this.pesqCod = pesqCod;
	}
	
	public void setPesqNome(String pesqNome) {
		this.pesqNome = pesqNome;
	}
	
	public String getPesqNome() {
		return pesqNome;
	}
	
	public void setPesqNis(Long pesqNis) {
		this.pesqNis = pesqNis;
	}
	public Long getPesqNis() {
		return pesqNis;
	}

}
