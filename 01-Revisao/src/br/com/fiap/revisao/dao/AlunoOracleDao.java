package br.com.fiap.revisao.dao;

import java.util.List;

import br.com.fiap.revisao.bean.Aluno;

public class AlunoOracleDao implements AlunoDao {

	@Override
	public void cadastrar(Aluno aluno) {
		System.out.println("Cadastrando o aluno no oracle");
		
	}

	@Override
	public List<Aluno> listar() {
		System.out.println("Listando o aluno do oracle");
		return null;
	}
	
}
