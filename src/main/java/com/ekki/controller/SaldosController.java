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

import com.ekki.model.Saldos;
import com.ekki.repo.SaldoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SaldosController {

	@Autowired
	SaldoRepository saldoRepository;

	@GetMapping("/saldos")
	public List<Saldos> buscarTodos() {
		System.out.println("Get all saldos...");

		List<Saldos> saldos = new ArrayList<>();
		saldoRepository.findAll().forEach(saldos::add);

		return saldos;
	}
	
	@GetMapping(value = "/saldos/{idusuario}")
	public List<Saldos> listaPorIdUsuario(@PathVariable int idusuario) {
		List<Saldos> saldo = saldoRepository.findByIdusuario(idusuario);
		return saldo;
	}
	
	@PostMapping(value = "/saldos/create")
	public Saldos salvaSaldo(@RequestBody Saldos saldo) {
		Saldos _saldos = saldoRepository.save(new Saldos(saldo.getSaldo(), saldo.getIdusuario()));
		return _saldos;
	}
	
	@PutMapping("/saldos/update/{id}")
	public ResponseEntity<Saldos> updateSaldo(
			@PathVariable("id") Long id, 
			@RequestBody Saldos saldo) {
		//parametros necessarios {idSolicitante, valor, idDestinatario}
	////verificar se usuario tem saldo necessario
//			//se nao tem, retorna mensagem de erro que saldo e insuficiente
//			// se sim segue
//			//subtrai esse saldo do usuario que esta transferindo
//			//adiciona o saldo ao usuario destinatario da transferencia
		System.out.println("Update Saldo with idusuario = " + id + "...");

		Optional<Saldos> saldoData = saldoRepository.findById(id);

		if (saldoData.isPresent()) {
			Saldos _saldo = saldoData.get();
			_saldo.setSaldo(saldo.getSaldo());
			return new ResponseEntity<>(saldoRepository.save(_saldo), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/saldos/delete/{id}")
	public ResponseEntity<String> deleteSaldo(@PathVariable("id") long id) {
		saldoRepository.deleteById(id);

		return new ResponseEntity<>("Saldo has been deleted!", HttpStatus.OK);
	}

}
