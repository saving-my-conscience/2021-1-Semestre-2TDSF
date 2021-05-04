package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Cidade;

public interface CidadeDAO extends GenericDAO<Cidade,Integer> {

	//Lista todas as cidades
	List<Cidade> listar();
	
	//Pesquisar cidade por ddd
	List<Cidade> buscarPorDdd(int ddd);
	
}