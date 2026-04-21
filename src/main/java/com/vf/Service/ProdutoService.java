package com.vf.Service;


import com.vf.Entity.Produto;
import com.vf.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> listarProduto(Long id){
        return produtoRepository.findById(id);
    }

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto alterarProduto(Produto produto, Long id){
        Produto produtoAlterado = produtoRepository.findById(id).get();
        produtoAlterado.setNome(produto.getNome());
        produtoAlterado.setPreco(produto.getPreco());
        produtoAlterado.setStatusPedido(produto.getStatusPedido());
        return produtoRepository.save(produtoAlterado);
    }
}
