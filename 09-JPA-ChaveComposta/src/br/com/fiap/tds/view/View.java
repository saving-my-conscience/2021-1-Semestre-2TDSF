package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AgenciaDao;
import br.com.fiap.tds.dao.ContaDao;
import br.com.fiap.tds.dao.impl.AgenciaDaoImpl;
import br.com.fiap.tds.dao.impl.ContaDaoImpl;
import br.com.fiap.tds.entity.Agencia;
import br.com.fiap.tds.entity.Conta;
import br.com.fiap.tds.entity.ContaPk;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma AgenciaDao e Cont`ao
		AgenciaDao agenciaDao = new AgenciaDaoImpl(em);
		ContaDao contaDao = new ContaDaoImpl(em);
		
		//Instanciar uma agencia
		Agencia agencia = new Agencia("FiapBank Online");
		
		//Instanciar uma conta
		Conta conta = new Conta(agencia, 100, Calendar.getInstance());
		
		//Cadastrar a agencia e conta
		agenciaDao.create(agencia);
		contaDao.create(conta);
		
		try {
			contaDao.commit();
			System.out.println("Conta e agencia cadastradas!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar uma conta pela PK
			ContaPk pk = new ContaPk(1,1);
			Conta busca = contaDao.read(pk);
			
			System.out.println(busca.getNumero() + " " + busca.getAgencia().getNome());
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}