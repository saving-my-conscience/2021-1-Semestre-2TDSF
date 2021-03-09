package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Exercicio06 {

	public static void main(String[] args) {
		//Instanciar uma conta corrente
		ContaCorrente cc = new ContaCorrente(
				1, 2, Calendar.getInstance(), 100, TipoConta.COMUM);
		
		//Instanciar uma conta poupança
		ContaPoupanca cp = new ContaPoupanca(
				1, 23, new GregorianCalendar(2020, Calendar.JANUARY,1), 200, 1);
		
		//Chamar o método retirar
		try {
			cc.retirar(50);
			System.out.println("Saque efetuado!");
		} catch(SaldoInsuficienteException e) {
			System.err.println( e.getMessage() );
		} 
		
	}//main
	
}//classe
