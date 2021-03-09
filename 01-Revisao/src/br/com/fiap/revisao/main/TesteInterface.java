package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Aluno;
import br.com.fiap.revisao.dao.AlunoDao;
import br.com.fiap.revisao.dao.AlunoOracleDao;

// JSP <-> Servlet AlunoDao <-> DAO <-> Banco de Dados

public class TesteInterface {
	
	public static void main(String[] args) {
		//Instanciar um objeto do tipo AlunoDao
		AlunoDao dao = new AlunoOracleDao();
		
		dao.cadastrar(new Aluno());
	}
	
}
