package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.TipoCliente;
import br.com.fiap.tds.entity.Venda;

public class CadastroTeste {

	public static void main(String[] args) {
		//Obter uma instância da fabrica de entity manager
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		
		//Obter uma instância de entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar uma venda (Não gerenciado, Estado novo)
		Venda venda = new Venda(100, "Victor", 
									//ano, mes, dia, hora, minutos
				new GregorianCalendar(2021, Calendar.MARCH, 22, 10, 30),
				"Leandro", TipoCliente.PF);
		
		//Cadastrar (Venda -> recebe um id e passa a ser gerenciado)
		em.persist(venda);
		
		//Começar uma transação
		em.getTransaction().begin();
		
		//Realizar o commit
		em.getTransaction().commit();
		
		System.out.println("Venda registrada!");
		
		//Fechar as paradas
		em.close();
		fabrica.close();
		
	}
	
}
