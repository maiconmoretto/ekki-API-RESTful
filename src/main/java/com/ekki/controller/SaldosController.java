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
	
//	@PutMapping(value = "/saldos/update")
//	public Saldos atualizaSaldo(@RequestBody Saldos saldo) {
//		//parametros necessarios {idSolicitante, valor, idDestinatario}
////verificar se usuario tem saldo necessario
//		//se nao tem, retorna mensagem de erro que saldo e insuficiente
//		// se sim segue
//		//subtrai esse saldo do usuario que esta transferindo
//		//adiciona o saldo ao usuario destinatario da transferencia
//		Saldos _saldos = saldoRepository.save(new Saldos(saldo.getSaldo(), saldo.getIdusuario()));
//		return _saldos;
//	}
	
	@PutMapping(value = "/saldos/update")
	public Saldos atualizaSaldo(@RequestBody Saldos saldo) {
		Saldos _saldos = saldoRepository.save(new Saldos(saldo.getSaldo(), saldo.getIdusuario()));
		return _saldos;
	}
	
	@PostMapping(value = "/saldos/create")
	public Saldos salvaSaldo(@RequestBody Saldos saldo) {

		Saldos _saldos = saldoRepository.save(new Saldos(saldo.getSaldo(), saldo.getIdusuario()));
		return _saldos;
	}
	
	
	
	@PutMapping("/saldos/update/{id}")
	public ResponseEntity<Saldos> updateCustomer(
			@PathVariable("id") int id, 
			@RequestBody Saldos saldo) {
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
	
	
//	@PutMapping("/saldo/update/{id}")
//	public ResponseEntity<Saldos> atualizar(@PathVariable Long id,
//			@Valid @RequestBody Saldos saldo) {
//		Optional<Saldos> existente = saldoRepository.findById(id);
//		
//		if (existente == null) {
//			return ResponseEntity.notFound().build();
//		}
//		BeanUtils.copyProperties(saldo, existente, "id");
//			
//		existente = saldoRepository.save(existente);
//		
//		return ResponseEntity.ok(existente);
//	}
	
//
//	@DeleteMapping("/saldos/{id}")
//	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
//		System.out.println("Delete Customer with ID = " + id + "...");
//
//		saldoRepository.deleteById(id);
//
//		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
//	}
//
//	@DeleteMapping("/saldos/delete")
//	public ResponseEntity<String> deleteAllCustomers() {
//		System.out.println("Delete All Customers...");
//
//		saldoRepository.deleteAll();
//
//		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
//	}
//
//	@GetMapping(value = "saldos/age/{age}")
//	public List<Customer> findByAge(@PathVariable int age) {
//
//		List<Customer> customers = saldoRepository.findByAge(age);
//		return customers;
//	}
//

}
