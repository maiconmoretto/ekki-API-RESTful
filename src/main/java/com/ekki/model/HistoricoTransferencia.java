package com.ekki.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Date dataCadastro;

	@Column(name = "valor")
	private double valor;
	
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

	public void setDataCadastro(Date dataCadastro ) {
		this.dataCadastro = dataCadastro;
	}
	
	public Date getDataCadastro() {
		return this.dataCadastro;
	}
	
	
	public HistoricoTransferencia() {
		
	}
	
	public HistoricoTransferencia(
			int idUsuario,
			int idDestinatario,
			double valor) {
		this.idUsuario = idUsuario;
		this.idDestinatario = idDestinatario;
		this.valor = valor;
	}
}
