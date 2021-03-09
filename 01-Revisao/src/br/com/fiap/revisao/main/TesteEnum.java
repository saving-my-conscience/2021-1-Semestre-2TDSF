package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Aluno;
import br.com.fiap.revisao.bean.Genero;

public class TesteEnum {

	public static void main(String[] args) {
		//Genero.FEMININO;
		//Instanciar um Aluno
		Aluno aluno = new Aluno("Victor", "RM88923");
		
		//Definir o genêro do aluno
		aluno.setGenero(Genero.MASCULINO);
		
		//Validar se é uma aluna
		if (aluno.getGenero() == Genero.FEMININO) {
			System.out.println("É uma aluna");
		} 
		
		System.out.println(aluno.getGenero());
	}//main
	
}//classe
