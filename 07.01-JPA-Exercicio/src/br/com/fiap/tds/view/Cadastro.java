package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		//Cadastrar um sistema, caso e item em cascata:
		//Instanciar um sistema
		Sistema sistema = new Sistema("Vendas Online");
		
		//Instanciar 2 casos de teste 
		CasoTeste caso1 = new CasoTeste("Vendas", "Realização de uma venda");
		CasoTeste caso2 = new CasoTeste("Devolução", "Realizar uma devolução");
		
		//Adicionar os casos no sistema
		sistema.addCasoTeste(caso1);
		sistema.addCasoTeste(caso2);
		
		//Instanciar 3 itens de teste
		ItemTeste item1 = new ItemTeste("Venda de um produto por cartão");
		ItemTeste item2 = new ItemTeste("Venda de um produto por boleto");
		ItemTeste item3 = new ItemTeste("Devolução de um produto por compra realizada por cartão");
		
		//Adicionar os itens nos casos de teste
		caso1.addItemTeste(item1);
		caso1.addItemTeste(item2);
		
		caso2.addItemTeste(item3);
		
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um sisteemDao
		SistemaDao sistemaDao = new SistemaDaoImpl(em);
		
		try {
			//Cadastrar o sistema
			sistemaDao.create(sistema);
			sistemaDao.commit();
			System.out.println("Deu bom!");
		} catch (CommitException e) {
			System.out.println("Deu ruim..");
		}
		
		//Criar uma lista de ItensTeste
		List<ItemTeste> itens = new ArrayList<>();
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		
		//Instanciar um usuário com a lista de itens teste
		Usuario usuario = new Usuario("Bruno", itens);
		
		//Obter um UsuarioDao
		GenericDao<Usuario, Integer> usuarioDao = new GenericDaoImpl<Usuario, Integer>(em) {};
		
		//Cadastrar um usuario
		try {
			usuarioDao.create(usuario);
			usuarioDao.commit();
			System.out.println("Usuário registrado com os itens de teste!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
	
}//classe