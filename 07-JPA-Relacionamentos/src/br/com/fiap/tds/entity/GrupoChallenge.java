package br.com.fiap.tds.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GRUPO_CHALLENGE")
@SequenceGenerator(name = "grupo", sequenceName = "SQ_TB_GRUPO_CHALLENGE", allocationSize = 1)
public class GrupoChallenge {
	
	@Id
	@Column(name="cd_grupo")
	@GeneratedValue(generator = "grupo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_grupo", length = 80, nullable = false)
	private String nome;
	
	//Mapeamento do relacionamento um-para-um bidirecional
	//mappedBy -> nome do atributo que mapeia a FK
	@OneToOne(mappedBy = "grupo", cascade = CascadeType.ALL)
	private ProjetoChallenge projeto;
	
	public GrupoChallenge() {}
	
	public GrupoChallenge(String nome) {
		this.nome = nome;
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

	public ProjetoChallenge getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoChallenge projeto) {
		this.projeto = projeto;
	}
	
}