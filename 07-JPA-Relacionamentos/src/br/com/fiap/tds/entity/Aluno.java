package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {
	
	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private int codigo;
	
	@Column(name="nm_aluno", length = 100, nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length = 20)
	private Genero genero;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
