package br.com.cadunico.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadunico.model.Endereco;
import br.com.cadunico.model.Parentesco;
import br.com.cadunico.model.Usuario;
import br.com.cadunico.model.Zona;
import br.com.cadunico.repository.CadastroUsuarioRepository;
import br.com.cadunico.repository.EnderecoRepository;
import br.com.cadunico.service.CadastroUsuarioService;
import br.com.cadunico.service.NegocioException;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroUsuarioService usuarioService;

	@Inject
	private CadastroUsuarioRepository repositorio;

	@Inject
	private EnderecoRepository repositorioEndereco;

	private Usuario usuario;
	private Endereco endereco;

	private Endereco enderecoSelecionado;

	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
		this.endereco = new Endereco();

	}

	public String salvar() {

		try {

			this.usuario.setEndereco(endereco);

			this.usuarioService.salvar(usuario);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario salvo com sucesso!", null));

			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

			return "PessoasCadastradas.xhtml?faces-redirect=true";

		} catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar, tente novamente!", null));
			return "";
		}

	}

	public Usuario porCodFamiliar(Long u) {
		return usuarioService.porCodFamiliar(u);
	}

	// Fazer a Validação do código Familiar, para salvar apenas um
	// Passar esse método para o Service, validando se o usuario é RF ou não
	public void enderecoSelecionado() {

		this.enderecoSelecionado = repositorio.porEnderecoFamiliar(usuario.getCodFamiliar());

		if (enderecoSelecionado != null) {
			this.endereco = enderecoSelecionado;

		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {

		if (usuario.getId() != null) {
			this.endereco = repositorioEndereco.porId(usuario.getEndereco().getId());
			// this.pasta = repositorioPasta.porId(usuario.getPasta().getId());
		}

		this.usuario = usuario;

	}

	public Parentesco[] getParentescos() {
		return Parentesco.values();
	}

	public Zona[] getZonas() {
		return Zona.values();
	}

	public Endereco getEnderecoSelecionado() {
		return enderecoSelecionado;
	}

	public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
		this.enderecoSelecionado = enderecoSelecionado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
