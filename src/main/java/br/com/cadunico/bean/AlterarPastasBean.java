package br.com.cadunico.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.cadunico.model.Usuario;
import br.com.cadunico.repository.ControlePastasRepository;

@Named
@ViewScoped
public class AlterarPastasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ControlePastasRepository repositorio;
	

	private Usuario usuario;

	@PostConstruct
	public void init() {

		this.usuario = new Usuario();
		
	}

	public void alterar() {
		
		 //repositorio.alterar(usuario);
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		
		this.usuario = usuario;
		
	}

	
}
