package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Endereco;

public interface EnderecoDAO extends GenericDAO<Endereco,Integer>{

	//Pesquisar endereço por quantidade de habitantes maior
	List<Endereco> buscarPorQtdHabitantesMaior(int qtd);
	
	//Pesquisar endereço por CEP
	List<Endereco> buscarPorCep(int cep);
	
}
