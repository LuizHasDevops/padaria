package br.edu.infnet.luiz.controllers;

import br.edu.infnet.luiz.model.domain.Pao;
import br.edu.infnet.luiz.model.service.PaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PaoCrontroller {

    @Autowired
    private PaoService paoService;

    @GetMapping(value = "/pao/lista")
    public Collection<Pao> obterLista(){
        return paoService.obterLista();
    }

    @GetMapping(value =  "/pao/{id}")
    public Pao obterPorId(@PathVariable Integer id) {
        return paoService.obterPorId(id);
    }

    @PostMapping(value = "/pao/incluir")
    public void incluir(@RequestBody Pao pao) {
        paoService.incluir(pao);
    }

    @DeleteMapping(value = "/pao/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        paoService.excluir(id);
    }
}
