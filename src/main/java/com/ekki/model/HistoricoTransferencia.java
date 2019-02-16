package com.ekki.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "historico_transferencia")
public class HistoricoTransferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_historico_transferencia")
	private Long id;

	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "id_destinatario")
	private int idDestinatario;
	
	@Column(name = "data_cadastro")
	private java.sql.Timestamp dataCadastro;

	@Column(name = "valor")
	private double valor;
	
	@Column(name = "nome_destinatario")
	private String nomeDestinatario;
	
	@Column(name = "numero_conta")
	private String numeroConta;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(int idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public java.sql.Timestamp getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(java.sql.Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public HistoricoTransferencia() {
		
	}

	public HistoricoTransferencia(
			int idUsuario,
			int idDestinatario,
			double valor,
			String nomeDestinatario,
			String numeroConta) {
		this.idUsuario = idUsuario;
		this.idDestinatario = idDestinatario;
		this.valor = valor;
		this.nomeDestinatario = nomeDestinatario;
		this.numeroConta = numeroConta;
		
	}
}
