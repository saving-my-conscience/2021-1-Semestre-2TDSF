package br.com.fiap.revisao.bean;

public class Pessoa {
	
	//Modificadores de acesso:
	// private -> somente a própria classe;
	// public -> todos;
	// protected -> própria classe, classes no pacote e herança;
	// default (package) -> própria classe e classes no pacote;

	//Tipos primitivos: byte, short, char, int, long, float, double, boolean
	// Valor padrão: números: 0, boolean: false
	
	//Tipos de referência: String, Date, Blob....
	// Valor padrão: null 
	
	//Atributos
	private String nome;
	
	private String cpf;
	
	private int idade;
	
	private Genero genero;
	
	//Construtores
	public Pessoa(String nome) {
		this.nome = nome;
	} 
	
	public Pessoa() {}
	
	//Métodos
	public void andar() {
		System.out.println("Pessoa andando...");
	}
	
	//Sobrecarga
	public void andar(float velocidade) {
		System.out.println("Pessoa andando a " + velocidade);
	}
	
	public void setNome(String nome) {
	 	this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}