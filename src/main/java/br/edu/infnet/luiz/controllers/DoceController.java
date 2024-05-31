package br.edu.infnet.luiz.controllers;

import br.edu.infnet.luiz.model.domain.Doce;
import br.edu.infnet.luiz.model.service.DoceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DoceController {

    @Autowired
    private DoceService doceService;

    @GetMapping(value = "/doce/lista")
    public Collection<Doce> obterLista(){
        return doceService.obterLista();
    }

    @GetMapping(value = "/doce/{id}")
    public Doce obterPorId(@PathVariable Integer id){
        return doceService.obterPorId(id);
    }

    @PostMapping(value = "/doce/incluir")
    public void incluir(@RequestBody Doce doce){
        doceService.incluir(doce);
    }

    @DeleteMapping(value = "/doce/{id}/excluir")
    public void excluir(@PathVariable Integer id){
        doceService.excluir(id);
    }


}
