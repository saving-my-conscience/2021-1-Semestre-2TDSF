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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_USUARIO")
@SequenceGenerator(name="usuario",sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
public class Usuario {

	@Id
	@Column(name="cd_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private int codigo;
	
	@Column(name="nm_usuario", length = 50, nullable = false)
	private String nome;
	
	@CreationTimestamp
	@Column(name="dt_cadastro", updatable = false)
	private Calendar dataCadastro;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", length = 30)
	private TipoUsuario tipo;
	
	public Usuario() {}
	
	public Usuario(String nome, TipoUsuario tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Usuario(int codigo, String nome, TipoUsuario tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
}