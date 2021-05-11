package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import br.com.fiap.util.DataUtil;

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
		clientes = clienteDao.buscarPorNome("Leand");
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
		
		//Listar os clientes paginando
		clientes = clienteDao.listar(3, 10);
		System.out.println("Listar clientes paginando");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar pacotes por preço menor (Object[])
		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(10000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de vetor de Object");
		listaObjetos.forEach(o -> System.out.println(o[0] + " " + o[1]));
		
		//Pesquisar pacotes por preço menor (Pacote)
		pacotes = pacoteDao.buscarPorPrecoMenor2(10000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de Pacote");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getDataSaida()));
		
		//Pesquisar pacotes por preço menor e exibir a descricao (String)
		List<String> lista = pacoteDao.buscarPorPrecoMenor3(1000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de string");
		lista.forEach(d -> System.out.println(d));
		
		//Pesquisar pacotes por data de saída
		Calendar inicio = new GregorianCalendar(2021, Calendar.JANUARY, 10);
		Calendar fim = new GregorianCalendar(2021, Calendar.DECEMBER, 10);
		pacotes = pacoteDao.buscarPorData(inicio, fim);
		System.out.println("Buscar pacotes por data de saída");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));
		
		//Pesquisar clientes por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "Salvador");
		System.out.println("Buscar clientes por parte do nome e parte do nome da cidade");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));
		
		//Pesquisar clientes por estados
		List<String> estados = new ArrayList<>();
		estados.add("BA");
		estados.add("PR");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar clientes por estado:");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Pesquisar clientes por parte do nome sem diferenciar maiúsculas de minúsculas
		clientes = clienteDao.buscarPorNome2("a");
		System.out.println("Buscar por parte do nome sem case sensitive");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
