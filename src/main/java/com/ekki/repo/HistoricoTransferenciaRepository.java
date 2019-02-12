package com.ekki.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ekki.model.HistoricoTransferencia;



public interface HistoricoTransferenciaRepository extends CrudRepository<HistoricoTransferencia, Long> {
	List<HistoricoTransferencia> findById(int id);	
	List<HistoricoTransferencia> findByIdUsuario(int idUsuario);		
}
