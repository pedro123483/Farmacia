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

import com.farmacia.model.Produto;
import com.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtosfar")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> getById(@PathVariable int id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}		
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByDescricao(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
				
	}
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto nome){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(nome));
	}
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto nome){
		return ResponseEntity.ok(repository.save(nome));
	}
	@DeleteMapping("/{id}")
	public void delete (@PathVariable int id) {
		repository.deleteById(id);
	}
}
