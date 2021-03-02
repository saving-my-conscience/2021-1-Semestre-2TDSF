package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Aluno;
import br.com.fiap.revisao.bean.Pessoa;

public class TesteMetodos {

	public static void main(String args[]) {
		
		//Instanciar uma Pessoa
		Pessoa pessoa = new Pessoa();
		
		pessoa.andar(); // Pessoa
		
		Aluno aluno = new Aluno();
		
		aluno.andar(); // Aluno
		
		Pessoa p = new Aluno();
		
		p.andar(); // Aluno
		
		//Aluno a = new Pessoa(); //Não compila
		
		//Operador ternário
		int x = 11;
		if (x > 10) {
			System.out.println("Maior que dez");
		} else {
			System.out.println("Menor ou igual a dez");
		}
		
		System.out.println(x>10?"Maior que dez":"Menor ou igual a dez");
				
	}
	
}