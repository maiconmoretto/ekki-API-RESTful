package com.ekki.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ekki.model.Usuario;



public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	List<Usuario> findById(long id);
}
