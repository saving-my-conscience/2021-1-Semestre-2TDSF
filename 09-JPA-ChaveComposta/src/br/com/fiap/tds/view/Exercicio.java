package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ConsultaDao;
import br.com.fiap.tds.dao.impl.ConsultaDaoImpl;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exercicio.entity.Consulta;
import br.com.fiap.tds.exercicio.entity.Medico;
import br.com.fiap.tds.exercicio.entity.Paciente;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Exercicio {

	public static void main(String[] args) {
		//Obter o entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma ConsultaDao
		ConsultaDao dao = new ConsultaDaoImpl(em);
		
		//Instanciar um médico
		Medico medico = new Medico(123, "Drauzio");
		
		//Instanciar um paciente
		Paciente paciente = new Paciente("Maria", new GregorianCalendar(1990, Calendar.JANUARY, 1));
		
		//Instanciar uma Consulta
		Consulta consulta = 
				new Consulta(medico, paciente, new GregorianCalendar(2021, Calendar.JUNE, 30, 10, 0), null);
		
		//Cadastrar a consulta
		try {
			dao.create(consulta);
			dao.commit();
			System.out.println("Consulta, médico e paciente cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}