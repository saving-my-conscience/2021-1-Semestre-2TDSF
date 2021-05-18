package br.com.fiap.tds.entity;

import java.io.Serializable;

//Classe que mapeia a chave composta da tabela Conta
//Contém os atributos que formam a chave composta (mesmo nome dos atributos da Conta)

public class ContaPk implements Serializable {

	private int numero;
	
	private int agencia;
	
	public ContaPk() {}

	public ContaPk(int numero, int agencia) {
		this.numero = numero;
		this.agencia = agencia;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaPk other = (ContaPk) obj;
		if (agencia != other.agencia)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
}
