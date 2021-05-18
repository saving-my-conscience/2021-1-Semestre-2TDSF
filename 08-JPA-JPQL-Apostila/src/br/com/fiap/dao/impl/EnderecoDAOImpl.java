package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.entity.Endereco;

public class EnderecoDAOImpl extends GenericDAOImpl<Endereco,Integer> implements EnderecoDAO{

	public EnderecoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Endereco> buscarPorQtdHabitantesMaior(int qtd) {
		return em.createNamedQuery("Endereco.PorQuantidadeHabitantes", Endereco.class)
				.setParameter("numero", qtd)
				.getResultList();
	}

	@Override
	public List<Endereco> buscarPorCep(int cep) {
		return em.createNamedQuery("Endereco.PorCep", Endereco.class)
				.setParameter("pCep", cep)
				.getResultList();
	}

}
