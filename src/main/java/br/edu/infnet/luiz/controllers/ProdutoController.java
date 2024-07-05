package br.edu.infnet.luiz.controllers;

import br.edu.infnet.luiz.model.domain.Produto;
import br.edu.infnet.luiz.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/produto/lista")
    public Collection<Produto> obterLista(){
        return produtoService.obterLista();
    }

    @GetMapping(value =  "/produto/{id}")
    public Produto obterPorId(@PathVariable Integer id) {
        return produtoService.obterPorId(id);
    }

    @DeleteMapping(value = "/produto/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        produtoService.excluir(id);
    }
    @GetMapping(value =  "/produto/{peso}/peso")
    public Produto obterPorPeso(@PathVariable int peso) {
        return produtoService.obterPorPeso(peso);
    }

    @GetMapping(value = "/produto/{padeiroId}/lista")
    public Collection<Produto> obterListaPorPadeiro(@PathVariable Integer padeiroId){
        return produtoService.obterListaPorPadeiro(padeiroId);
    }
}
