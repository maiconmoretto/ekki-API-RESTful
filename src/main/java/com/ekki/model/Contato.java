package com.ekki.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_contato")
	private Long id;

	@Column(name = "cadastrado_por")
	private int cadastradoPor;
	

	@Column(name = "id_usuario_contato")
	private int idUsuarioContato;
	
	@Column(name = "nome_contato")
	private String nomeContato;
	
	@Column(name = "numero_conta")
	private int numeroConta;
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta; 
	}
	
	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCadastradoPor() {
		return cadastradoPor;
	}

	public void setCadastradoPor(int cadastradoPor) {
		this.cadastradoPor = cadastradoPor;
	}

	public int getIdUsuarioContato() {
		return idUsuarioContato;
	}

	public void setIdUsuarioContato(int idUsuarioContato) {
		this.idUsuarioContato = idUsuarioContato;
	}

	public Contato() {
		
	}
	
	public Contato(
			int cadastradoPor,
			int idUsuarioContato,
			String nomeContato,
			int numeroConta
	) {
		this.cadastradoPor = cadastradoPor;
		this.idUsuarioContato = idUsuarioContato;
		this.nomeContato = nomeContato;
		this.numeroConta = numeroConta;
	}
}
