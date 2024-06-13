package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.model.domain.Produto;
import br.edu.infnet.luiz.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluir(Produto produto){
        produtoRepository.save(produto);
    }

    public Collection<Produto> obterLista(){
        return (Collection<Produto>) produtoRepository.findAll();
    }

    public Produto obterPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }

    public long obterQtde() {
        return produtoRepository.count();
    }

}
