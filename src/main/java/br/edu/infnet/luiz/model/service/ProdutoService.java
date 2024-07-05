package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.model.domain.Produto;
import br.edu.infnet.luiz.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluir(Produto produto) {
        try {
            produtoRepository.save(produto);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
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
    public Produto obterPorPeso(int peso){
        return produtoRepository.findByPeso(peso);
    }

    public Collection<Produto> obterListaPorPadeiro(Integer id){
        return (Collection<Produto>) produtoRepository.findByPadeiroId(id);
    }
}
