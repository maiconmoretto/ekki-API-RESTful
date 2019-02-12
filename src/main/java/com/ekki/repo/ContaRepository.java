package com.ekki.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ekki.model.Conta;



public interface ContaRepository extends CrudRepository<Conta, Long> {
	List<Conta> findById(int id);	
	List<Conta> findByIdUsuario(int idUsuario);
	List<Conta> findByNumeroConta(int numeroConta);	
}
