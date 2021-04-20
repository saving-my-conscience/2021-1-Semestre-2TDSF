package br.com.fiap.tds.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	//Mapeamento do relacionamento muitos-para-um
	@ManyToOne
	@JoinColumn(name = "cd_grupo", nullable = false)
	private GrupoChallenge grupo;
	
	//Mapeamento do relacionamennto muitos-para-muitos unidirecional
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	//JoinTable -> configuração da tabela associativa
	//name -> nome da tabela
	//joinColumns -> coluna que armazena a FK/PK da entidade que estamos
	//inverseJoinColumns -> coluna que armazena a FK/PK do outro lado da relação
	@JoinTable(name="TB_ALUNO_NANO_COURSE",
			joinColumns = @JoinColumn(name="cd_aluno"),
			inverseJoinColumns = @JoinColumn(name="cd_course"))
	private List<NanoCourse> cursos;
	
	public Aluno(){}

	public Aluno(String nome, Genero genero, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
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

	public GrupoChallenge getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}

	public List<NanoCourse> getCursos() {
		return cursos;
	}

	public void setCursos(List<NanoCourse> cursos) {
		this.cursos = cursos;
	}
}
