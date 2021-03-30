package br.com.fiap.tds.exception;

import br.com.fiap.tds.entity.Venda;

public class VendaNotFoundException extends Exception {

	public VendaNotFoundException() {
		super("Venda não encontrada");
	}
	
	public VendaNotFoundException(String msg) {
		super(msg);
	}
	
}
