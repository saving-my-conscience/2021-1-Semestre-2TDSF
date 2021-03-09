package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

	//CTRL + 1
	private TipoConta tipo;
	
	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		//validar se a conta é comum e o saldo fica negativo dps do saque
		if (tipo == TipoConta.COMUM && saldo - valor < 0) {
			//Lançar uma exception
			throw new SaldoInsuficienteException(saldo);
		}
		saldo -= valor;
	}

	//CTRL + 3 -> gcuf
	public ContaCorrente() {}
	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	
}
