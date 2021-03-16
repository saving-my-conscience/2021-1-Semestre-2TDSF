package br.com.fiap.tds.bean;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.annotation.Tabela;

@Tabela(nome="TAB_CLIENTE")
public class Cliente {

	@Coluna(nome = "cd_cliente")
	private int codigo;
	
	@Coluna(nome = "nm_cliente", tamanho = 60)
	private String nome;
	
	@Coluna(nome = "nr_cpf", tamanho = 14)
	private String cpf;
	
	//CTRL + 3 -> ggas

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}