package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_NANO_COURSE")
@SequenceGenerator(name="nano", sequenceName = "SQ_TB_NANO_COURSE", allocationSize = 1)
public class NanoCourse {

	@Id
	@Column(name="cd_nano_course")
	@GeneratedValue(generator = "nano", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_nano", nullable = false, length = 100)
	private String nome;
	
	@Column(name="nr_aulas", nullable = false)
	private Integer numeroAulas;
	
	@Column(name="nr_creditos", nullable = false)
	private Integer numeroCreditos;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_nivel", length = 30)
	private NivelCurso nivel;

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

	public Integer getNumeroAulas() {
		return numeroAulas;
	}

	public void setNumeroAulas(Integer numeroAulas) {
		this.numeroAulas = numeroAulas;
	}

	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public NivelCurso getNivel() {
		return nivel;
	}

	public void setNivel(NivelCurso nivel) {
		this.nivel = nivel;
	}

}
