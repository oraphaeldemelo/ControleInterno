package br.com.cadunico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.cadunico.model.AgendamentoVisitas;
import br.com.cadunico.model.Zona;

public class AgendamentoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	@Inject
	public AgendamentoRepository(EntityManager em) {
		this.em = em;
	}

	public AgendamentoVisitas salvar(AgendamentoVisitas av) {

		return em.merge(av);
	}

	public List<AgendamentoVisitas> listarSede() {
		return em.createQuery("from AgendamentoVisitas where (enderecoVisita.zona= :zona and situacao is null)",
				AgendamentoVisitas.class).setParameter("zona", Zona.URBANA).getResultList();

	}

	public List<AgendamentoVisitas> listarRural() {
		return em.createQuery("from AgendamentoVisitas where enderecoVisita.zona= :zona", AgendamentoVisitas.class)
				.setParameter("zona", Zona.RURAL).getResultList();
	}

	public List<AgendamentoVisitas> listarConcluidas() {
		return em.createQuery("from AgendamentoVisitas where situacao is not null", AgendamentoVisitas.class)
				.getResultList();
	}


	public AgendamentoVisitas porNome(String nome) {

		try {
			return em.createQuery("from AgendamentoVisitas where nome = :nome", AgendamentoVisitas.class)
					.setParameter("nome", nome).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	public AgendamentoVisitas porId(Long id) {
		return em.find(AgendamentoVisitas.class, id);
	}

}
