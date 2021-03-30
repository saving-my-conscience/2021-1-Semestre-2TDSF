package br.com.fiap.tds.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_VENDA")
@SequenceGenerator(name="venda", sequenceName = "SQ_TB_VENDA", allocationSize = 1)
public class Venda {

	@Id
	@Column(name="cd_venda")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda")
	private int codigo;
	
	@Column(name="vl_venda", nullable = false)
	private double valor;
	
	@Column(name="nm_cliente", nullable = false, length = 60)
	private String cliente;
	
	@Column(name="dt_venda", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@CreationTimestamp //Coloca a data de cadastro de forma automática
	@Column(name="dt_cadastro" , updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	@Column(name="nm_vendedor", length = 60)
	private String vendedor;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo_cliente", length = 2)
	private TipoCliente tipoCliente;
	
	public Venda() {}
	
	//Sem código e sem a data de cadastro (Utilizado para o cadastro)
	public Venda(double valor, String cliente, Calendar data, String vendedor, TipoCliente tipoCliente) {
		super();
		this.valor = valor;
		this.cliente = cliente;
		this.data = data;
		this.vendedor = vendedor;
		this.tipoCliente = tipoCliente;
	}

	//Sem a data de cadastro (Utilizado para a atualização)
	public Venda(int codigo, double valor, String cliente, Calendar data, String vendedor, TipoCliente tipoCliente) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.cliente = cliente;
		this.data = data;
		this.vendedor = vendedor;
		this.tipoCliente = tipoCliente;
	}

	//CTRL + 3 -> gcuf
	
	//Método que é executado automáticamente antes de cadastrar
	@PrePersist
	public void executarAntesCadastro() {
		System.out.println("Antes de cadastrar...");
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return "Código: "+ codigo + 
				"\nCliente: " + cliente + 
				"\nValor: " + valor + 
				"\nVendedor: " + vendedor +
				"\nTipo Cliente: " + tipoCliente +
				"\nData Venda: " + formatador.format(data.getTime()) +
				"\nData Cadastro: " + formatador.format(dataCadastro.getTime());
	}

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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
}
