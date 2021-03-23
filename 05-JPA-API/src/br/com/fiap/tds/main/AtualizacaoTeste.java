package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.TipoCliente;
import br.com.fiap.tds.entity.Venda;

// View <-> Controller <-> DAO <-> BD

public class AtualizacaoTeste {
	
	public static void main(String[] args) {
		
		//Obter uma instancia da fabrica e do entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um objeto do tipo Venda com um id existente no banco (Estado: detached)
		Venda venda = new Venda(1, 999, "Pedro", new GregorianCalendar(2021, Calendar.MAY, 30),
																		"Murilo", TipoCliente.PF);
		
		//Atualizar a venda
		Venda vendaGerenciada = em.merge(venda); //Retorna a cópia do objeto venda gerenciado pelo em
		
		//venda.setValor(9999);
		
		//vendaGerenciada.setValor(9999);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
		
	}

}
