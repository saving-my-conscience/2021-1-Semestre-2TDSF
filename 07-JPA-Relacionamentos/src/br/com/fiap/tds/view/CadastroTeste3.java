package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {

	public static void main(String[] args) {
		//Obter o Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um AlunoDao e GrupoChallengeDao
		GenericDao<Aluno,Integer> alunoDao = new GenericDaoImpl<Aluno,Integer>(em) {};
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		
		//Cadastrar um aluno com um grupo que já existe no banco
		try {
			//Pesquisar um grupo
			GrupoChallenge grupo = grupoDao.read(1);
			
			//Instanciar o aluno e setar o grupo
			Aluno aluno = new Aluno("Pedro", Genero.MASCULINO, 
										new GregorianCalendar(2002, Calendar.DECEMBER, 10));
			aluno.setGrupo(grupo);
			
			//Cadastrar o aluno
			alunoDao.create(aluno);
			alunoDao.commit();
			System.out.println("Aluno registrado!");
		
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Associar um curso e um aluno que já existem no banco
		//Obter um NanoCourseDao
		GenericDao<NanoCourse, Integer> nanoDao = new GenericDaoImpl<NanoCourse, Integer> (em) {};
		
		try {
			//Pesquisar um aluno e um curso
			Aluno aluno = alunoDao.read(3);
			NanoCourse nano = nanoDao.read(1);
			
			//Colocar o curso na lista de curso do aluno
			aluno.getCursos().add(nano);
			
			//Dar um update no aluno
			alunoDao.update(aluno);
			alunoDao.commit();
			
			System.out.println("Aluno matriculado!");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
