package br.com.cadunico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.cadunico.model.Parentesco;
import br.com.cadunico.model.Usuario;
import br.com.cadunico.util.jpa.Transactional;

public class ControlePastasRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {

		return em.createQuery("from Usuario where parentesco= :parentesco")
				.setParameter("parentesco", Parentesco.RESPONSAVEL_FAMILIAR).getResultList();
	}

	public List<Usuario> porPasta(Integer id) {
		return em.createQuery("from Usuario where pasta = :pasta and parentesco = 1", Usuario.class).setParameter("pasta", id)
				.getResultList();
	}

	public List<Usuario> porCodFamiliar(Long codigo) {
		return em.createQuery("from Usuario where codFamiliar = :codigo and parentesco = 1", Usuario.class).setParameter("codigo", codigo)
				.getResultList();
	}

	public List<Usuario> porNome(String nome) {
		return em.createQuery("from Usuario where nome like :nome and parentesco = 1", Usuario.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}

	public List<Usuario> porNis(Long nis) {
		return em.createQuery("from Usuario where nis = :nis and parentesco = 1", Usuario.class).setParameter("nis", nis).getResultList();
	}

	public List<Usuario> porLocalidade(String pesqLocal) {
		return em.createQuery("from Usuario where endereco.logradouro = :endereco and parentesco = 1", Usuario.class)
				.setParameter("endereco", pesqLocal).getResultList();
	}

}
