package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ContaDao;
import br.com.fiap.tds.entity.Conta;
import br.com.fiap.tds.entity.ContaPk;

public class ContaDaoImpl extends GenericDaoImpl<Conta, ContaPk> implements ContaDao {

	public ContaDaoImpl(EntityManager em) {
		super(em);
	}

}
