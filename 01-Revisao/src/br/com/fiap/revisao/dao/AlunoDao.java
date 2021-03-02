package br.com.fiap.revisao.dao;

import java.util.List;
import br.com.fiap.revisao.bean.Aluno;

public interface AlunoDao {

	void cadastrar(Aluno aluno);
	
	List<Aluno> listar();
	
}