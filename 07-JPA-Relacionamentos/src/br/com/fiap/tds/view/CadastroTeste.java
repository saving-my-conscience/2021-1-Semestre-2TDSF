package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		//Obter o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter o GrupoDao e ProjetoDao
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);
		
		//Criar o grupo
		GrupoChallenge grupo = new GrupoChallenge("Teste Grupo de Challenge");
		
		//Criar o projeto com o grupo
		ProjetoChallenge projeto = new ProjetoChallenge("IOT para vida", "Melhorando a vida", 
				new GregorianCalendar(2021, Calendar.JUNE, 20), grupo, null);
		
		//Cadastrar o grupo
		//grupoDao.create(grupo);
		
		//Cadastrar o projeto
		projetoDao.create(projeto);
		
		//Commit
		try {
			projetoDao.commit();
			System.out.println("Grupo e projeto cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
