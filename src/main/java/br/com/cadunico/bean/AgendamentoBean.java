package br.com.cadunico.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadunico.model.AgendamentoVisitas;
import br.com.cadunico.model.EnderecoVisita;
import br.com.cadunico.service.AgendamentoService;
import br.com.cadunico.service.NegocioException;

@Named
@ViewScoped
public class AgendamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendamentoService servico;
	private AgendamentoVisitas selecionado;

	@PostConstruct
	public void init() {

		this.selecionado = new AgendamentoVisitas();
		this.selecionado.setEnderecoVisita(new EnderecoVisita());

	}

	public void alterar() {
		if (selecionado.getId() != null) {
			editar();
		} else {
			salvar();
		}
	}

	public String salvar() {

		try {

			this.servico.salvar(selecionado);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agendamento feito com sucesso!", null));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

			return "ListaAgendamentos.xhtml?faces-redirect=true";

		} catch (NegocioException e) {
			e.printStackTrace();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), null));
			return "";

		}

	}

	public String editar() {

		this.servico.editar(selecionado);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração feita com sucesso!", null));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		return "ListaAgendamentos.xhtml?faces-redirect=true";

	}

	public AgendamentoVisitas getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(AgendamentoVisitas selecionado) {
		this.selecionado = selecionado;
	}

}
