package br.com.fiap.tds.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.bean.Cliente;

public class Teste {

	public static void main(String[] args) {
		//Instanciar um cliente
		Cliente cliente = new Cliente();
		
		//API de reflection -> recuperar a estrutura da classe
		//Recuperar o nome da classe
		String nome = cliente.getClass().getName();
		System.out.println(nome);
		
		System.out.println("**MÉTODOS:");
		//Recuperar os métodos da classe cliente
		Method[] metodos = cliente.getClass().getDeclaredMethods();
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
		System.out.println("**ATRIBUTOS:");
		//Recuperar os atributos da classe cliente 
		Field[] atributos = cliente.getClass().getDeclaredFields();
		for (Field f : atributos) {
			System.out.println(f.getName());
			//Recuperar a anotação @Coluna
			Coluna a = f.getAnnotation(Coluna.class);
			System.out.println("Nome no banco: " + a.nome());
			System.out.println("Tamanho: " + a.tamanho());
			System.out.println("Único: " + a.unico());
		}
		
	}//main
	
}//classe