package com.ekki.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ekki.model.Saldos;



public interface SaldoRepository extends CrudRepository<Saldos, Long> {
	List<Saldos> findByIdusuario(int idusuario);
}
