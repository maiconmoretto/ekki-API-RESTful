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

import com.ekki.model.CartaoCredito;
import com.ekki.model.Saldo;
import com.ekki.repo.CartaoCreditoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CartaoCreditoController {

	@Autowired
	CartaoCreditoRepository cartaoCreditoRepository;

	@GetMapping("/cartaoCredito")
	public List<CartaoCredito> listarCartaoCredito() {
		List<CartaoCredito> cartaoCredito = new ArrayList<>();
		cartaoCreditoRepository.findAll().forEach(cartaoCredito::add);

		return cartaoCredito;
	}
	
	@GetMapping(value = "/cartaoCredito/{idUsuario}")
	public List<CartaoCredito> listaHistoricoPorIdUsuario(@PathVariable int idUsuario) {
		List<CartaoCredito> cartaoCredito = cartaoCreditoRepository.findByIdUsuario(idUsuario);
		return cartaoCredito;
	}

	@PostMapping(value = "/cartaoCredito/create")
	public CartaoCredito salvaCartaoCredito(@RequestBody CartaoCredito cartaoCredito) {
		CartaoCredito _cartaoCredito = cartaoCreditoRepository.save(
				new CartaoCredito(
				cartaoCredito.getIdUsuario(),
				cartaoCredito.getValidadeCartao(),
				cartaoCredito.getNumeroCartao(),
				cartaoCredito.getNomeUsuarioCartao(),
				cartaoCredito.getCodigoSeguranca()));
		return _cartaoCredito;
	}
	
	@PutMapping("/cartaoCredito/update/{id}")
	public ResponseEntity<CartaoCredito> atualizaCartãoCredito(
			@PathVariable("id") Long id, 
			@RequestBody CartaoCredito cartaoCredito) {
		Optional<CartaoCredito> cartaoCreditoData = cartaoCreditoRepository.findById(id);
		if (cartaoCreditoData.isPresent()) {
			CartaoCredito _cartaoCredito = cartaoCreditoData.get();
			_cartaoCredito.setCodigoSeguranca(cartaoCredito.getCodigoSeguranca());
			_cartaoCredito.setNomeUsuarioCartao(cartaoCredito.getNomeUsuarioCartao());
			_cartaoCredito.setNumeroCartao(cartaoCredito.getNumeroCartao());;
			_cartaoCredito.setValidadeCartao(cartaoCredito.getValidadeCartao());;
						
			return new ResponseEntity<>(cartaoCreditoRepository.save(_cartaoCredito), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/cartaoCredito/delete/{id}")
	public ResponseEntity<String> deletaSaldo(@PathVariable("id") long id) {
		cartaoCreditoRepository.deleteById(id);

		return new ResponseEntity<>("Cartao has been deleted!", HttpStatus.OK);
	}
}
