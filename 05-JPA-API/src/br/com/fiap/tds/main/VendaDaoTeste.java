package br.com.fiap.tds.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.VendaDao;
import br.com.fiap.tds.dao.impl.VendaDaoImpl;
import br.com.fiap.tds.entity.TipoCliente;
import br.com.fiap.tds.entity.Venda;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.VendaNotFoundException;

public class VendaDaoTeste {

	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Obter uma instâncem da VendaDao
		VendaDao dao = new VendaDaoImpl(em);
		
		//Cadastrar
		Venda venda = new Venda(100, "Gustavo", Calendar.getInstance(), "Murilo", TipoCliente.PF);
		
		try { 
			dao.create(venda);
			dao.commit();
			System.out.println("Venda registrada!");
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar e exibir os dados
		try {
			venda = dao.read(21);
			System.out.println(venda);
		} catch(VendaNotFoundException e) {
			System.out.println("Venda não encontrada");
		}
		
		//Atualizar
		venda = new Venda(4, 300, "Paulo", Calendar.getInstance(), "Maria", TipoCliente.PJ);
		try {
			dao.update(venda);
			dao.commit();
			System.out.println("Venda atualizada!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.delete(4);
			dao.commit();
			System.out.println("Venda removida!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} catch (VendaNotFoundException e) {
			System.out.println("Venda não encontrada para ser removida");
		}
		
		//Fechar
		em.close();
		fabrica.close();
		
	}//main
}//classe
