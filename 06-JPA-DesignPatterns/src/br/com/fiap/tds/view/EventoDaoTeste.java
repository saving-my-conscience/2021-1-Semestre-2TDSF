package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Evento;
import br.com.fiap.tds.entity.TipoEvento;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class EventoDaoTeste {

	public static void main(String[] args) {
		//Obter o Entity Manager
		EntityManager em = EntityManagerFactorySingleton
									.getInstance().createEntityManager();
		
		//Obter uma instância do Dao Genérico para o Evento
		//Instancia uma classe filha da GenericDaoImpl (Classe anônima)
		GenericDao<Evento,Integer> dao = 
							new GenericDaoImpl<Evento, Integer>(em) {};
							
		//Realizar as operações...
		Evento evento = new Evento("Next", 
				Calendar.getInstance(), 10, TipoEvento.PRIVADO, true);
		
		try {
			dao.create(evento);
			dao.commit();
			System.out.println("Evento registrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			evento = dao.read(1);
			System.out.println(evento.getNome());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
