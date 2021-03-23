package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		
		//Instanciar uma fabrica de gerenciador de entidades
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		
		//Instanciar o Gerenciador de Entidades 
		EntityManager em = fabrica.createEntityManager();
		
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
