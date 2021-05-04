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
	
}
