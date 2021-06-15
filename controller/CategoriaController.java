package com.farmacia.controller;

import java.util.List;

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

import com.farmacia.model.Categoria;
import com.farmacia.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoriasfar")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable int id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}		
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String tipo){
		return ResponseEntity.ok(repository.findAllByTipoContainingIgnoreCase(tipo));
				
	}
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria tipo){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tipo));
	}
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria tipo){
		return ResponseEntity.ok(repository.save(tipo));
	}
	@DeleteMapping("/{id}")
	public void delete (@PathVariable int id) {
		repository.deleteById(id);
	}
}
	
