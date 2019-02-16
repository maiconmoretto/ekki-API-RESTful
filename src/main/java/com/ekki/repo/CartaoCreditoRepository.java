package com.ekki.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ekki.model.CartaoCredito;;



public interface CartaoCreditoRepository extends CrudRepository<CartaoCredito, Long> {
	List<CartaoCredito> findByIdUsuario(int idUsuario);
	Optional<CartaoCredito> findById(Long id);
}
