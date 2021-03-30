package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SALA")
@SequenceGenerator(name="sala", sequenceName = "SQ_TB_SALA", allocationSize = 1)
public class Sala {

	@Id
	@Column(name="cd_sala")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala")
	private int codigo;
	
	@Column(name="nm_sala", nullable = false, length = 50)
	private String nome;
	
	@Column(name="nr_assentos")
	private int numeroAssentos;
	
	public Sala() {}
	
	public Sala(String nome, int numeroAssentos) {
		super();
		this.nome = nome;
		this.numeroAssentos = numeroAssentos;
	}
	
	public Sala(int codigo, String nome, int numeroAssentos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.numeroAssentos = numeroAssentos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroAssentos() {
		return numeroAssentos;
	}

	public void setNumeroAssentos(int numeroAssentos) {
		this.numeroAssentos = numeroAssentos;
	}
	
}
