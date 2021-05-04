package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma CidadeDao
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		//Exibir o nome das cidades cadastradas!
		List<Cidade> cidades = cidadeDao.listar();
		System.out.println("Cidades cadastradas:");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}
		
		//Exibir as cidades de ddd 19
		cidades = cidadeDao.buscarPorDdd(19);
		System.out.println("Cidades por DDD");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " " + cidade.getDdd());
		}
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		//Listar os clientes
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Listar Clientes");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar os clientes por parte do nome
		clientes = clienteDao.buscarPorNome("Lean");
		System.out.println("Pesquisar por parte do nome");
		clientes.forEach(c -> System.out.println(c.getNome()));

		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		//Pesquisar um transporte pelo código
		Transporte transporte = transporteDao.pesquisar(2);
		
		//Pesquisar os pacotes por um transporte
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		
		//Exibir os pacotes
		System.out.println("Buscar pacotes por transporte");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa()));
		
		//Pesquisar os clientes do PR
		clientes = clienteDao.buscarPorEstado("PR");
		System.out.println("Buscar cliente por estado");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Pesquisar clientes por dias de reserva (10 dias)
		clientes = clienteDao.buscarPorDiasReserva(10);
		System.out.println("Clientes por dias de reserva");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
