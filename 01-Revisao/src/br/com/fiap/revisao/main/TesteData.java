package br.com.fiap.revisao.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteData {

	public static void main(String[] args) {
		//Instanciar uma objeto Calendar com a data atual
		Calendar hoje = Calendar.getInstance(); //objeto com a data atual

		//Instanciar um objeto Calendar com a data da entrega da challenge 20/05/2021
											    // ano, mês, dia
		Calendar challenge = new GregorianCalendar(2021, Calendar.MAY, 20);
		
		//challenge.set(Calendar.DAY_OF_MONTH, 20);
		//challenge.set(Calendar.MONTH, 5);
		
		//Instanciar um formatador de data
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		//Exibir a data
		System.out.println( formatador.format(hoje.getTime()));
		
		//Exibir a data
		System.out.println( formatador.format(challenge.getTime()));
	}
	
}
