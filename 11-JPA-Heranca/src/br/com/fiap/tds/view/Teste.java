package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.PessoaDao;
import br.com.fiap.tds.dao.impl.PessoaDaoImpl;
import br.com.fiap.tds.entity.Cliente;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.entity.Pessoa;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) {
		//Cadastrar uma pessoa, funcionário e cliente
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		PessoaDao dao = new PessoaDaoImpl(em);
		
		Pessoa pessoa = new Pessoa("Allen", new GregorianCalendar(1990, Calendar.SEPTEMBER, 20));
		
		Funcionario func = new Funcionario("Julio", 
				new GregorianCalendar(1999, Calendar.MARCH, 2), 1000.0, "Desenvolvedor Java");
		
		Cliente cliente = new Cliente("Marcia", 
				new GregorianCalendar(2000, Calendar.MAY, 9), "marcia@gmail.com", true);
		
		try {
			dao.create(pessoa);
			dao.create(cliente);
			dao.create(func);
			dao.commit();
			System.out.println("Pessoa, cliente e funcionário cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
