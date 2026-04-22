package com.vf.Controller;


import com.vf.Entity.Produto;
import com.vf.Entity.ProdutoRequestDTO;
import com.vf.Entity.ProdutoResponseDTO;
import com.vf.Entity.StatusPedido;
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
    public List<ProdutoResponseDTO> listarProdutos(){
        return service.listarProdutos().stream().map(p -> new ProdutoResponseDTO(p.getId(),
                p.getNome(), p.getPreco(), p.getStatusPedido())).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> listarProduto(@PathVariable Long id){
        if (service.listarProduto(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return service.listarProduto(id).map(p -> ResponseEntity.ok(new ProdutoResponseDTO(
                (p.getId()), p.getNome(), p.getPreco(), p.getStatusPedido())
        )).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@RequestBody ProdutoRequestDTO dto){
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setStatusPedido(StatusPedido.PENDENTE);

        Produto novoProduto = service.criarProduto(produto);

        ProdutoResponseDTO resposta = new ProdutoResponseDTO(novoProduto.getId(),
                novoProduto.getNome(), novoProduto.getPreco(), novoProduto.getStatusPedido());

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        if (service.listarProduto(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        service.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<ProdutoResponseDTO> alterarProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto){
        if (service.listarProduto(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Produto dadosNovos = new Produto();
        dadosNovos.setNome(dto.nome());
        dadosNovos.setPreco(dto.preco());

        Produto produtoAtualizadp = service.alterarProduto(dadosNovos, id);

        ProdutoResponseDTO response = new ProdutoResponseDTO(produtoAtualizadp.getId(), produtoAtualizadp.getNome(),
                produtoAtualizadp.getPreco(), produtoAtualizadp.getStatusPedido());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
