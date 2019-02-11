package com.ekki.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ekki.model.Saldo;



public interface SaldoRepository extends CrudRepository<Saldo, Long> {
	List<Saldo> findByIdusuario(int idusuario);
	Optional<Saldo> findById(int id);
	
}
