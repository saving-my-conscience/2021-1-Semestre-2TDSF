package br.com.fiap.revisao.dao;

import java.util.List;

import br.com.fiap.revisao.bean.Aluno;

public class AlunoMySqlDao implements AlunoDao {

	@Override
	public void cadastrar(Aluno aluno) {
		System.out.println("Cadastrando no MySql");
		
	}

	@Override
	public List<Aluno> listar() {
		System.out.println("Recuperando o aluno do MySql");
		return null;
	}

}
