package com.vf.Controller;


import com.vf.Entity.Produto;
import com.vf.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listarProdutos(){
        return service.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarProduto(@PathVariable Long id){
        if (!service.listarProduto(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Produto produtoListado = service.listarProduto(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(produtoListado);
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        Produto novoProduto = service.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        if(!service.listarProduto(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        service.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Produto> alterarProduto(@PathVariable Long id, @RequestBody Produto produto){
        if (!service.listarProduto(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Produto produtoAlterado = service.alterarProduto(produto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoAlterado);
    }

}
