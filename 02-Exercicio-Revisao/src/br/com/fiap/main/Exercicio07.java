package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio07 {

	public static void main(String[] args) {
		//Criar uma lista de conta corrente
		List<ContaCorrente> lista = new ArrayList<>();
		
		//Adicionar 3 contas
		lista.add(new ContaCorrente(1,23, Calendar.getInstance(), 2000, TipoConta.ESPECIAL));
		lista.add(new ContaCorrente(1, 323, Calendar.getInstance(), 3000, TipoConta.PREMIUM));
		lista.add(new ContaCorrente(1,343, Calendar.getInstance(), 4000, TipoConta.COMUM));
		
		//Exibir o saldo das contas
		for (ContaCorrente cc : lista) {
			System.out.println(cc.getSaldo());
		}
		
	}
	
}
