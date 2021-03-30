package br.com.fiap.tds.dao;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

// GenericDao<Cliente,String> dao 

public interface GenericDao<E,K> {

	void create(E entidade);
	
	E read(K id) throws EntityNotFoundException;
	
	void update(E entidade);
	
	void remove(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
	
}