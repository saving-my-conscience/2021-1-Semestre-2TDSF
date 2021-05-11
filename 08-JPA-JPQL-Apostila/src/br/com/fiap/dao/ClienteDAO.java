package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer> {
	
	//Pesquisar por parte do nome
	List<Cliente> buscarPorNome(String nome);
	
	//Pesquisar clientes por estado
	List<Cliente> buscarPorEstado(String estado);
	
	//Pesquisar por qtd de dias de reserva
	List<Cliente> buscarPorDiasReserva(int dias);
	
	//Pesquisar por parte do nome e parte do nome da cidade
	List<Cliente> buscar(String nome, String cidade);
	
	//Pesquisar por estados
	List<Cliente> buscarPorEstados(List<String> estados);
	
	//Pesquisar por parte do nome, sem diferenciar as letras maiúsculas e minúsuculas
	List<Cliente> buscarPorNome2(String nome);
	
	//Contar a quantidade de clientes por estado
	long contarPorEstado(String estado);
	
}
