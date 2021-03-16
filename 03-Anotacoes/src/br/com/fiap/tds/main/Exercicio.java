package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Aluno;
import br.com.fiap.tds.bean.Cliente;
import br.com.fiap.tds.orm.Orm;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar um aluno e um orm
		Aluno aluno = new Aluno();
		Cliente cliente = new Cliente();
		Orm orm = new Orm();
		
		//Chamar o método de gerarPesquisa passando o aluno
		System.out.println(orm.gerarPesquisa(aluno));
		System.out.println(orm.gerarPesquisa(cliente));
	}
	
}
