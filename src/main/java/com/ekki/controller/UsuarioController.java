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

import com.ekki.model.Usuario;
import com.ekki.repo.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public List<Usuario> buscarTodos() {
		List<Usuario> usuario = new ArrayList<>();
		usuarioRepository.findAll().forEach(usuario::add);

		return usuario;
	}
	
	@GetMapping(value = "/usuarios/{idusuario}")
	public List<Usuario> listaPorIdUsuario(@PathVariable int idusuario) {
		List<Usuario> usuario = usuarioRepository.findById(idusuario);
		return usuario;
	}
//	
//	@PostMapping(value = "/saldos/create")
//	public Saldo salvaSaldo(@RequestBody Saldo saldo) {
//		Saldo _saldos = saldoRepository.save(new Saldo(saldo.getSaldo(), saldo.getIdusuario()));
//		return _saldos;
//	}
//	
//	@PutMapping("/saldos/update/{id}")
//	public ResponseEntity<Saldo> updateSaldo(
//			@PathVariable("id") Long id, 
//			@RequestBody Saldo saldo) {
//		System.out.println("Update Saldo with idusuario = " + id + "...");
//
//		Optional<Saldo> saldoData = saldoRepository.findById(id);
//
//		if (saldoData.isPresent()) {
//			Saldo _saldo = saldoData.get();
//			_saldo.setSaldo(saldo.getSaldo());
//			return new ResponseEntity<>(saldoRepository.save(_saldo), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@DeleteMapping("/saldos/delete/{id}")
//	public ResponseEntity<String> deleteSaldo(@PathVariable("id") long id) {
//		saldoRepository.deleteById(id);
//
//		return new ResponseEntity<>("Saldo has been deleted!", HttpStatus.OK);
//	}

}
