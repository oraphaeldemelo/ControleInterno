/*OBS. DEPOIS COLOCAR ICONES NOS BOTÕES DE AÇÕES 
 * 
 * 
 */

package br.com.cadunico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadunico.model.AgendamentoVisitas;
import br.com.cadunico.repository.AgendamentoRepository;
import br.com.cadunico.service.AgendamentoService;
import br.com.cadunico.service.NegocioException;
import br.com.cadunico.util.jpa.Transactional;

@Named
@ViewScoped
public class ListaAgendamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendamentoRepository repositorio;
	private AgendamentoService servico;

	private List<AgendamentoVisitas> visitasSede = new ArrayList<AgendamentoVisitas>();
	private List<AgendamentoVisitas> visitasRural = new ArrayList<AgendamentoVisitas>();
	private List<AgendamentoVisitas> visitasConcluidas = new ArrayList<AgendamentoVisitas>();

	private AgendamentoVisitas visitaSelecionada;

	@PostConstruct
	public void init() {
		//visitasSede = repositorio.listarSede();
		//visitasRural = repositorio.listarRural();
		//visitasConcluidas = repositorio.listarConcluidas();
		visitaSelecionada = new AgendamentoVisitas();

	}

	public void concluir() {
		AgendamentoVisitas nova = repositorio.porId(visitaSelecionada.getId());
		nova.setSituacao(visitaSelecionada.getSituacao());
		try {
			servico.salvar(nova);
		} catch (NegocioException e) {
			e.printStackTrace();
		}

	}

	public List<AgendamentoVisitas> getVisitasSede() {
		return visitasSede;
	}

	public List<AgendamentoVisitas> getVisitasRural() {
		return visitasRural;
	}

	public List<AgendamentoVisitas> getVisitasConcluidas() {
		return visitasConcluidas;
	}

	public AgendamentoVisitas getVisitaSelecionada() {
		return visitaSelecionada;
	}

	public void setVisitaSelecionada(AgendamentoVisitas visitaSelecionada) {
		this.visitaSelecionada = visitaSelecionada;
	}

}
