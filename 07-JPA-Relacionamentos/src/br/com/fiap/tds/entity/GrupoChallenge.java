package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	//Mapeamento do relacionamento bidirecional
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Aluno> alunos;
	
	//Método para o um-para-muitos
	public void addAluno(Aluno aluno) {
		if (alunos == null)
			alunos = new ArrayList<>();
		//Adicionar o aluno no grupo (Lista)
		alunos.add(aluno);
		//Setar o grupo no aluno (Mapeia a FK, para inserir no banco)
		aluno.setGrupo(this); //this referência ao próprio objeto
	}
	
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}