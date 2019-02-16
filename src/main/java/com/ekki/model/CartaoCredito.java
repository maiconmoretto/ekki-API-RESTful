package com.ekki.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cartao_credito")
public class CartaoCredito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cartao_credito")
	private Long id;

	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "validade_cartao")
	private String validadeCartao;
	
	@Column(name = "nome_usuario_cartao")
	private String nomeUsuarioCartao;
	
	@Column(name = "numero_cartao")
	private String numeroCartao;
	
	@Column(name = "codigo_seguranca")
	private int codigoSeguranca;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

		
	public String getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(String validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public String getNomeUsuarioCartao() {
		return nomeUsuarioCartao;
	}

	public void setNomeUsuarioCartao(String nomeUsuarioCartao) {
		this.nomeUsuarioCartao = nomeUsuarioCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public CartaoCredito() {
		
	}
	
	public CartaoCredito(
		int idUsuario,
		String validadeCartao,
		String numeroCartao,
		String nomeUsuarioCartao,
		int codigoSeguranca
	) {
		this.idUsuario = idUsuario;
		this.validadeCartao = validadeCartao;
		this.numeroCartao = numeroCartao;
		this.nomeUsuarioCartao = nomeUsuarioCartao;
		this.codigoSeguranca = codigoSeguranca;
	}
}
