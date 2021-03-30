package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Venda;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.VendaNotFoundException;

//Diminuir o acoplamento (Dependência)
// View - Controller (VendaDao) - DAO - Banco de Dados

public interface VendaDao {

	void create(Venda venda);
	
	Venda read(int id) throws VendaNotFoundException;
	
	void update(Venda venda);
	
	void delete(int id) throws VendaNotFoundException;
	
	void commit() throws CommitException;
	
}