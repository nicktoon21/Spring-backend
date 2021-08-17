package br.app.estoque.controller;

import br.app.estoque.model.Produto;
import br.app.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Produto> buscaProdutos(@PathVariable(value ="id") long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping("/criar")
    public Produto criaProdutos(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
