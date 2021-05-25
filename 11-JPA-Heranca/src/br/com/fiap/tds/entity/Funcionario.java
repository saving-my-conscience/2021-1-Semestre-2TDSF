package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


//JOINED
//Modifica o nome da coluna de PK/FK
@PrimaryKeyJoinColumn(name = "cd_funcionario")

@Entity
@Table(name="TB_EAD_FUNCIONARIO")
public class Funcionario extends Pessoa {

	@Column(name="vl_salario")
	private Double salario;
	
	@Column(name="ds_cargo", length = 40)
	private String cargo;

	public Funcionario() {}
	
	public Funcionario(String nome, Calendar dataNascimento, Double salario, String cargo) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
