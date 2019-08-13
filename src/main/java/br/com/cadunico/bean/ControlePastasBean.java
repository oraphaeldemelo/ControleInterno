package br.com.cadunico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadunico.model.Usuario;
import br.com.cadunico.repository.ControlePastasRepository;

@Named
@ViewScoped
public class ControlePastasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ControlePastasRepository repositorio;

	List<Usuario> usuarios;

	private Long pesqCod;
	private Long pesqNis;
	private String pesqNome;
	private String pesqLocal;

	@PostConstruct
	public void init() {

		usuarios = new ArrayList<Usuario>();

	}

	public void porCodFamiliar() {
		this.usuarios = repositorio.porCodFamiliar(pesqCod);
	}

	public void porNis() {
		this.usuarios = repositorio.porNis(pesqNis);
	}

	public void porNome() {
		this.usuarios = repositorio.porNome(pesqNome);
	}

	public void porLocal() {
		this.usuarios = repositorio.porLocalidade(pesqLocal);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Long getPesqCod() {
		return pesqCod;
	}

	public void setPesqCod(Long pesqCod) {
		this.pesqCod = pesqCod;
	}

	public Long getPesqNis() {
		return pesqNis;
	}

	public void setPesqNis(Long pesqNis) {
		this.pesqNis = pesqNis;
	}

	public String getPesqNome() {
		return pesqNome;
	}

	public void setPesqNome(String pesqNome) {
		this.pesqNome = pesqNome;
	}

	public String getPesqLocal() {
		return pesqLocal;
	}

	public void setPesqLocal(String pesqLocal) {
		this.pesqLocal = pesqLocal;
	}

}
