package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//SINGLE_TABLE
//@DiscriminatorValue("C")

//JOINED
//Modifica o nome da coluna de PK/FK
@PrimaryKeyJoinColumn(name = "cd_cliente")

@Entity
@Table(name="TB_EAD_CLIENTE")
public class Cliente extends Pessoa {

	@Column(name="ds_email", length = 60)
	private String email;
	
	@Column(name="st_vip")
	private Boolean vip;
	
	public Cliente() {}

	public Cliente(String nome, Calendar dataNascimento, String email, Boolean vip) {
		super(nome, dataNascimento);
		this.email = email;
		this.vip = vip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}
	
}
