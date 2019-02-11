package com.ekki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saldo")
public class Saldos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_saldo")
	private Long id;

	@Column(name = "saldo")
	private int saldo;

	@Column(name = "id_usuario")
	private int idusuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public Saldos() {
	}

	public Saldos(int saldo, int idusuario) {
		this.idusuario = idusuario;
		this.saldo = saldo;
	}

	

	@Override
	public String toString() {
		return "Customer [idusuario=" + idusuario + ", saldo=" + saldo + "]";
	}
}
