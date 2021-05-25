package br.com.fiap.tds.exercicio.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEDICO")
public class Medico {
	
	@Id
	@Column(name="nr_crm")
	private int crm;
	
	@Column(name="nm_medico", nullable = false, length = 100)
	private String nome;
	
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;
	
	public Medico() {}

	public Medico(int crm, String nome) {
		this.crm = crm;
		this.nome = nome;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
}
