package br.com.fiap.tds.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Teste.java - compila -> Bytecode (Teste.class) -> Execução (JVM)

//Target -> determina onde pode ser utilizada a anotação
//Field -> atributos
@Target( { ElementType.FIELD, ElementType.METHOD })

//Retention -> determina até quando a anotação estará presente
//SOURCE -> até o .java
//CLASS -> até o .class (default)
//RUNTIME -> até a JVM
@Retention(RetentionPolicy.RUNTIME)

public @interface Coluna {

	String nome();
	boolean unico() default false;
	int tamanho() default 255;
	
}

