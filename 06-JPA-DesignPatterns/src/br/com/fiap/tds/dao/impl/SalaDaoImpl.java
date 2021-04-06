package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SalaDao;
import br.com.fiap.tds.entity.Sala;

public class SalaDaoImpl extends GenericDaoImpl<Sala, Integer> 
													implements SalaDao {

	public SalaDaoImpl(EntityManager em) {
		super(em);
	}

}