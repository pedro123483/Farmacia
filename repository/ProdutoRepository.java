package com.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
}
