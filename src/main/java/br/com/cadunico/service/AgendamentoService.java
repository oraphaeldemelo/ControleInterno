package br.com.cadunico.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.cadunico.model.AgendamentoVisitas;
import br.com.cadunico.repository.AgendamentoRepository;
import br.com.cadunico.util.jpa.Transactional;

public class AgendamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendamentoRepository repositorio;

	@Transactional
	public AgendamentoVisitas salvar(AgendamentoVisitas av) throws NegocioException {

		AgendamentoVisitas selecionado = repositorio.porNome(av.getNome());

		if (selecionado != null) {
			throw new NegocioException("Já existe uma visita marcada com esse nome");
		}

		return repositorio.salvar(av);

	}

	@Transactional
	public AgendamentoVisitas editar(AgendamentoVisitas av) {

		return repositorio.salvar(av);
	}

}
