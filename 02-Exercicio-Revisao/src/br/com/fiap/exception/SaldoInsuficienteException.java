package br.com.fiap.exception;

//@SuppressWarnings("serial")
public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {}
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	
	public SaldoInsuficienteException(double valor) {
		super("Saldo insuficiente, m�ximo: " + valor);
	}
	
}