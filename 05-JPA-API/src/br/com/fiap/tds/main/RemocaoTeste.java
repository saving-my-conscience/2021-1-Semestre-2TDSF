package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Venda;

public class RemocaoTeste {

	public static void main(String[] args) {
		//Instanciar uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar a venda que será removida
		Venda venda = em.find(Venda.class, 2);
		
		//Remover
		em.remove(venda);
		
		//commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(venda);
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
