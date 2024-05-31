package br.edu.infnet.luiz.controllers;

import br.edu.infnet.luiz.model.domain.Padeiro;
import br.edu.infnet.luiz.model.service.PadeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PadeiroController {

    @Autowired
    private PadeiroService padeiroService;

    @GetMapping(value = "/padeiro/lista")
    public Collection<Padeiro> obterLista(){
        return padeiroService.obterLista();
    }

    @GetMapping(value =  "/padeiro/{id}")
    public Padeiro obterPorId(@PathVariable Integer id) {
        return padeiroService.obterPorId(id);
    }

    @PostMapping(value = "/padeiro/incluir")
    public void incluir(@RequestBody Padeiro padeiro) {
        padeiroService.incluir(padeiro);
    }

    @DeleteMapping(value = "/padeiro/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        padeiroService.excluir(id);
    }
}
