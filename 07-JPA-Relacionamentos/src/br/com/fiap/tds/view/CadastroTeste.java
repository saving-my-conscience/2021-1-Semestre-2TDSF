package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.entity.NivelCurso;
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
		
		//Instanciar uns 3 alunos e adicionar no grupo...
		Aluno aluno1 = new Aluno("Pedro", Genero.MASCULINO, new GregorianCalendar(2000, Calendar.MARCH, 4));
		Aluno aluno3 = new Aluno("Victor", Genero.MASCULINO, new GregorianCalendar(2001, Calendar.APRIL, 18));
		Aluno aluno2 = new Aluno("Gustavo", Genero.MASCULINO, new GregorianCalendar(2002, Calendar.OCTOBER, 15));
		
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		grupo.addAluno(aluno3);
		
		//Instanciar uns 2 cursos
		NanoCourse nano1 = new NanoCourse("Java", 40, 10, NivelCurso.INTERMEDIARIO);
		NanoCourse nano2 = new NanoCourse("Técnicas de Negociação", 20, 5, NivelCurso.BASICO);
		
		//Criar uma lista de cursos e adicionar os cursos
		List<NanoCourse> cursos = new ArrayList<>();
		cursos.add(nano1);
		cursos.add(nano2);
		
		//Setar a lista em 2 alunos
		aluno1.setCursos(cursos);
		aluno2.setCursos(cursos);
		
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
