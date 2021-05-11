package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer> {

	//Obter todos os pacotes por um transporte específico (Objeto Transporte)
	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	//Buscar pacotes por preço menor, retornar a descrição e quantidade de dias (Object[])
	List<Object[]> buscarPorPrecoMenor(float preco);
	
	//Buscar pacotes por preço menor, retornando a descrição e quantidade de dias (Pacote)
	List<Pacote> buscarPorPrecoMenor2(float preco);
	
	//Buscar pacotes por preço menor, retornando a descrição (String)
	List<String> buscarPorPrecoMenor3(float preco);
	
	//Buscar pacotes por data de saída
	List<Pacote> buscarPorData(Calendar inicio, Calendar fim);
	
}
