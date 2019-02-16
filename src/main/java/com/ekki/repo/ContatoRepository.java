package com.ekki.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ekki.model.Contato;



public interface ContatoRepository extends CrudRepository<Contato, Long> {
	List<Contato> findByCadastradoPor(int cadastradoPor);
	Optional<Contato> findById(Long id);
}
