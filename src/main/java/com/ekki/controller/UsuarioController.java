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

import com.ekki.model.Saldo;
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
	
	@GetMapping(value = "/usuarios/{id}")
	public List<Usuario> listaPorIdUsuario(@PathVariable long id) {
		List<Usuario> usuario = usuarioRepository.findById(id);
		return usuario;
	}

	@PostMapping(value = "/usuarios/create")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
	
		Usuario _usuarios = usuarioRepository.save(
			new Usuario(
					usuario.getNome(),
					usuario.getSenha(),
					usuario.getLogin(),
					usuario.getIdConta()
			)
		);
		return _usuarios;
	}


	@PutMapping("/usuarios/update/{id}")
	public ResponseEntity<Usuario> atualizaUsuario(
			@PathVariable("id") Long id, 
			@RequestBody Usuario usuario) {
		Optional<Usuario> usuarioData = usuarioRepository.findById(id);

		if (usuarioData.isPresent()) {
			Usuario _usuario = usuarioData.get();
			_usuario.setIdConta(usuario.getIdConta());
			_usuario.setLogin(usuario.getLogin());
			_usuario.setNome(usuario.getNome());
			_usuario.setSenha(usuario.getSenha());
			return new ResponseEntity<>(usuarioRepository.save(_usuario), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/usuarios/delete/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable("id") long id) {
		usuarioRepository.deleteById(id);

		return new ResponseEntity<>("Usuario has been deleted!", HttpStatus.OK);
	}

}
