package br.com.cadunico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.cadunico.model.Usuario;
import br.com.cadunico.service.NegocioException;
import br.com.cadunico.util.jpa.Transactional;

public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Transactional
	public void excluirUsuario(Usuario usuario) throws NegocioException {

		try {
			Usuario usuarioSelecionado = porId(usuario.getId());
			em.remove(usuarioSelecionado);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Usuario não pode ser excluido");
		}
	}

	public Usuario porId(Long id) {
		return em.find(Usuario.class, id);

	}

	public List<Usuario> listar() {
		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}

	public List<Usuario> porCodFamiliar(Long codigo) {
		return em.createQuery("from Usuario where codFamiliar = :codigo", Usuario.class).setParameter("codigo", codigo)
				.getResultList();
	}

	public List<Usuario> porNome(String nome) {
		return em.createQuery("from Usuario where nome like :nome", Usuario.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}

	public List<Usuario> porNis(Long nis) {
		return em.createQuery("from Usuario where nis = :nis", Usuario.class).setParameter("nis", nis).getResultList();
	}

	public List<Usuario> porLocalidade(String pesqLocal) {
		return em.createQuery("from Usuario where usuario.endereco.logradouro = :endereco", Usuario.class)
				.setParameter("endereco", pesqLocal).getResultList();
	}

}
