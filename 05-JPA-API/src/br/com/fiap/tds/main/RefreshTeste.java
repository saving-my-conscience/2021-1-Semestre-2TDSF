package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Venda;

public class RefreshTeste {

	public static void main(String[] args) {
		//Instanciar uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar uma venda de código 1
		Venda venda = em.find(Venda.class, 1);
		
		//Exibir os dados da venda
		System.out.println(venda);
		
		//Alterar os valores do objeto (setValor, setCliente...)
		venda.setCliente("Bruno");
		venda.setValor(1000);
		
		//Exibir os dados da venda
		System.out.println(venda);
		
		//Chamar o refresh
		em.refresh(venda);
		
		//Exibir os dados da venda
		System.out.println(venda);
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
