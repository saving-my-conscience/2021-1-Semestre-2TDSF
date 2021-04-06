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
@Table(name="TB_EVENTO")
@SequenceGenerator(name="evento",sequenceName = "SQ_TB_EVENTO",allocationSize = 1)
public class Evento {
	
	@Id
	@Column(name="cd_evento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento")
	private int codigo;
	
	@Column(name="nm_evento", length = 100, nullable = false )
	private String nome;
	
	@Column(name="dt_evento")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name="vl_ingresso")
	private double valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo_evento", length = 40)
	private TipoEvento tipo;
	
	@Column(name="st_beneficente")
	private boolean beneficente;
	
	public Evento() {}
	
	public Evento(String nome, Calendar data, double valor, TipoEvento tipo, boolean beneficente) {
		this.nome = nome;
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
		this.beneficente = beneficente;
	}

	public Evento(int codigo, String nome, Calendar data, double valor, TipoEvento tipo, boolean beneficente) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
		this.beneficente = beneficente;
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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public boolean isBeneficente() {
		return beneficente;
	}

	public void setBeneficente(boolean beneficente) {
		this.beneficente = beneficente;
	}
	
}
