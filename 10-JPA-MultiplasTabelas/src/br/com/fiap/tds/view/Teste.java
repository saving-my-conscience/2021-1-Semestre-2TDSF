package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um FuncionarioDao
		FuncionarioDao dao = new FuncionarioDaoImpl(em);
		
		//Instanciar um funcionário
		Funcionario f = new Funcionario("Salvio", new GregorianCalendar(1980, Calendar.JULY, 10), 
				20000.0, 1234, 4234);
		
		//Cadastrar o funcionário
		try {
			dao.create(f);
			dao.commit();
			System.out.println("Funcionário cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um funcionario
		try {
			Funcionario f2 = dao.read(1);
			System.out.println(f2.getNome() + " " + f2.getSalario());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
