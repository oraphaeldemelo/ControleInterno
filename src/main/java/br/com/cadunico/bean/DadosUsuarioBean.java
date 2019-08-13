package br.com.cadunico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadunico.model.Usuario;
import br.com.cadunico.service.PessoasCadastradasService;

@Named
@ViewScoped
public class DadosUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoasCadastradasService servico;
	
	private Usuario usuarioSelecionado;
	private List<Usuario> familiaSelecionada;

	@PostConstruct
	public void init(){
		this.usuarioSelecionado = new Usuario();
		this.familiaSelecionada = new ArrayList<Usuario>();
		System.out.println("o código do usuario é: " + usuarioSelecionado.getCodFamiliar());
		
	}
	
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getFamiliaSelecionada() {
		return familiaSelecionada = servico.porCodFamiliar(usuarioSelecionado.getCodFamiliar());
	}

	
}
