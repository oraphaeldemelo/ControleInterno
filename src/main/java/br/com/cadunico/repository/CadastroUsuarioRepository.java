package br.com.cadunico.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.cadunico.model.Endereco;
import br.com.cadunico.model.Usuario;

public class CadastroUsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private EntityManager em;

	@Inject
	public CadastroUsuarioRepository(EntityManager em){
		this.em = em;
	}
	
	public Usuario salvar(Usuario usuario) {
		return em.merge(usuario);
	}

	public Usuario porCodFamiliar(Long cod) {

		try {
			return em.createQuery("from Usuario where codFamiliar = :cod", Usuario.class).setParameter("cod", cod)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Endereco porEnderecoFamiliar(Long id) {

		try {
			return em.createQuery("select e.endereco from Usuario e where e.codFamiliar = :cod", Endereco.class)
					.setParameter("cod", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario porNis(Long nis) {

		try {
			return em.createQuery("from Usuario where nis= :nis", Usuario.class).setParameter("nis", nis)
					.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario porId(Long id) {
		return em.find(Usuario.class, id);
	}
}
