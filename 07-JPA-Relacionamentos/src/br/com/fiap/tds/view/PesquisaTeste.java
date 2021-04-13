package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {
	
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
				
		//Obter o ProjetoDao
		ProjetoChallengeDao dao = new ProjetoChallengeDaoImpl(em);
		
		try {
			//Pesquisar o projeto de código 1
			ProjetoChallenge projeto = dao.read(1);
			
			//Exibir o nome do projeto
			System.out.println(projeto.getNome());
			
			//Exibir o nome do grupo
			//System.out.println(projeto.getGrupo().getNome());
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
