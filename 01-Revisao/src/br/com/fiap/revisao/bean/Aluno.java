package br.com.fiap.revisao.bean;

public class Aluno extends Pessoa {

	private String rm;
	
	//Construtor
	public Aluno() {}
	
	public Aluno(String nome, String rm) {
		super(nome);
		this.rm = rm;
	}
	
	@Override
	public String toString() {
		return getNome() + " - " + rm;
	}
	
	//Sobrescrita -> mesmo método na classe filha
	@Override
	public void andar() {
		System.out.println("Aluno andando..");
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}
	
}