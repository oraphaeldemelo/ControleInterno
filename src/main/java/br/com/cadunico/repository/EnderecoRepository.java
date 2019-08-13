package br.com.cadunico.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.cadunico.model.Endereco;

public class EnderecoRepository implements Serializable{

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	
	@Inject
	public EnderecoRepository(EntityManager em){
		this.em = em;
	}
	
	public Endereco porId(Long id){
		return em.find(Endereco.class, id);
	}

}
