package com.ekki.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
//
//	@PostMapping(value = "/saldos/create")
//	public Customer postCustomer(@RequestBody Customer customer) {
//
//		Customer _customer = saldoRepository.save(new Customer(customer.getName(), customer.getAge()));
//		return _customer;
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
//	@PutMapping("/saldos/{id}")
//	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
//		System.out.println("Update Customer with ID = " + id + "...");
//
//		Optional<Customer> customerData = saldoRepository.findById(id);
//
//		if (customerData.isPresent()) {
//			Customer _customer = customerData.get();
//			_customer.setName(customer.getName());
//			_customer.setAge(customer.getAge());
//			_customer.setActive(customer.isActive());
//			return new ResponseEntity<>(saldoRepository.save(_customer), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}
