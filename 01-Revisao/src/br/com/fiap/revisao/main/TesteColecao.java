package br.com.fiap.revisao.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.bean.Aluno;

public class TesteColecao {

	public static void main(String[] args) {
		 
		//Criar uma lista de alunos
		List<Aluno> lista = new ArrayList<Aluno>();
		
		//Adicionar dois alunos na lista
		lista.add(new Aluno("Victor", "RM29304"));
		
		Aluno aluno = new Aluno("Murilo", "RM98292");
		lista.add(aluno);
		
		//Exibir os alunos da lista
		for (int i = 0; i < lista.size() ; i++) {
			System.out.println(lista.get(i).getRm() + " " + lista.get(i).getNome());
		}
		
		//Foreach
		for (Aluno item : lista) {
			System.out.println(item);
			//System.out.println(item.getRm() + " " + item.getNome());
		}
		
		//Mapa
		Map<String,Aluno> mapa = new HashMap<String, Aluno>();
		
		mapa.put("aluno1", new Aluno("João", "RM123123"));
		mapa.put("aluno2", new Aluno("Antonio", "RM24234"));
		
		//Recuperar o aluno através da chave
		aluno = mapa.get("aluno2");
		System.out.println(aluno.getNome() + " " + aluno.getRm());
						
		
	}//main
	
}//classe




