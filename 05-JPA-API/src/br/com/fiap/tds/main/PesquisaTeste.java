package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Venda;

public class PesquisaTeste {

	public static void main(String[] args) {
		//Obter uma instancia da fabrica e do entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar pela PK (Retorna null ou o objeto gerenciado)
		Venda venda = em.find(Venda.class, 1);
		
		//Exibir os dados da venda
		System.out.println(venda);
		
		//Altera o valor da venda em memória
		venda.setValor(900);
		
		//Commit -> atualiza a venda no banco
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
