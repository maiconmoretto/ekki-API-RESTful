package com.ekki.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekki.model.HistoricoTransferencia;
import com.ekki.repo.HistoricoTransferenciaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HistoricoTransferenciaController {

	@Autowired
	HistoricoTransferenciaRepository historicoTransferenciaRepository;

	@GetMapping("/historicoTransferencia")
	public List<HistoricoTransferencia> listarHistoricoTransferencia() {
		List<HistoricoTransferencia> historicoTransferencia = new ArrayList<>();
		historicoTransferenciaRepository.findAll().forEach(historicoTransferencia::add);

		return historicoTransferencia;
	}
	
	@GetMapping(value = "/historicoTransferencia/{idUsuario}")
	public List<HistoricoTransferencia> listaHistoricoPorIdUsuario(@PathVariable int idUsuario) {
		List<HistoricoTransferencia> historicoTransferencia = historicoTransferenciaRepository.findByIdUsuario(idUsuario);
		return historicoTransferencia;
	}

	@PostMapping(value = "/historicoTransferencia/create")
	public HistoricoTransferencia salvaHistoricoTransferencia(@RequestBody HistoricoTransferencia historicoTransferencia) {
		HistoricoTransferencia _historicoTransferencia = historicoTransferenciaRepository.save(
				new HistoricoTransferencia(
				historicoTransferencia.getIdUsuario(),
				historicoTransferencia.getIdDestinatario(),
				historicoTransferencia.getValor(),
				historicoTransferencia.getNomeDestinatario(),
				historicoTransferencia.getNumeroConta(),
				historicoTransferencia.getNumeroCartao()));
		
		return _historicoTransferencia;
	}
	
	@DeleteMapping("/historicoTransferencia/delete/{id}")
	public ResponseEntity<String> deletaTransferencia(@PathVariable("id") long id) {
		historicoTransferenciaRepository.deleteById(id);

		return new ResponseEntity<>("Transferencia has been deleted!", HttpStatus.OK);
	}
}
