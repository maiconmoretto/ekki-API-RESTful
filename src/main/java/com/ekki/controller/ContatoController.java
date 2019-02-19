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

import com.ekki.model.Contato;
import com.ekki.repo.ContatoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;

	@GetMapping("/contato")
	public List<Contato> listarContato() {
		List<Contato> contato = new ArrayList<>();
		contatoRepository.findAll().forEach(contato::add);

		return contato;
	}
	
	@GetMapping(value = "/contato/{cadastradoPor}")
	public List<Contato> listaHistoricoPorIdUsuario(@PathVariable int cadastradoPor) {
		List<Contato> contato = contatoRepository.findByCadastradoPor(cadastradoPor);
		return contato;
	}

	@PostMapping(value = "/contato/create")
	public Contato salvaContato(@RequestBody Contato contato) {
		Contato _contato = contatoRepository.save(
			new Contato(
				contato.getCadastradoPor(),
				contato.getIdUsuarioContato(),
				contato.getNomeContato(),
				contato.getNumeroConta()
			)
		);
		return _contato;
	}
	
	@PutMapping("/contato/update/{id}")
	public ResponseEntity<Contato> atualizaContato(
			@PathVariable("id") Long id, 
			@RequestBody Contato contato) {
		Optional<Contato> contatoData = contatoRepository.findById(id);
		if (contatoData.isPresent()) {
			Contato _contato = contatoData.get();
			_contato.setCadastradoPor(contato.getCadastradoPor());
			_contato.setIdUsuarioContato(contato.getIdUsuarioContato());
			_contato.setNomeContato(contato.getNomeContato());
			_contato.setNumeroConta(contato.getNumeroConta());
			return new ResponseEntity<>(contatoRepository.save(_contato), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/contato/delete/{id}")
	public ResponseEntity<String> deletaSaldo(@PathVariable("id") long id) {
		contatoRepository.deleteById(id);

		return new ResponseEntity<>("Contato has been deleted!", HttpStatus.OK);
	}
}
