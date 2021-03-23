package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TAB_PRODUTO")
@SequenceGenerator(name="produto",sequenceName = "SEQ_TB_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@Column(name="cd_produto")
	private int codigo;
	
	@Column(name="vl_produto", nullable = false)
	private double valor;
	
	@Column(name="dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	@Column(name="nr_itens")
	private int numeroItens;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_categoria")
	private Categoria categoria;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_produto")
	private String descricao;
	
	@Column(name="nm_produto", nullable = false, length = 50)
	private String nome;
	
	@Column(name="ds_tamanho", length = 50)
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	
	//CTRL + 3 -> GGAS

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getNumeroItens() {
		return numeroItens;
	}

	public void setNumeroItens(int numeroItens) {
		this.numeroItens = numeroItens;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	
}
