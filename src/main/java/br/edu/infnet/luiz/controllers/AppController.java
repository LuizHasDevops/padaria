package br.edu.infnet.luiz.controllers;

import br.edu.infnet.luiz.model.service.DoceService;
import br.edu.infnet.luiz.model.service.PadeiroService;
import br.edu.infnet.luiz.model.service.PaoService;
import br.edu.infnet.luiz.model.service.ProdutoService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private PadeiroService padeiroService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private PaoService paoService;
    @Autowired
    private DoceService doceService;

    @GetMapping(value = "/")
    public String telaHome(Model model){

        model.addAttribute("qtdePadeiro", padeiroService.obterQtde());
        model.addAttribute("qtdeProduto", produtoService.obterQtde());
        model.addAttribute("qtdeDoce", doceService.obterQtde());
        model.addAttribute("qtdePao", paoService.obterQtde());

        return "home";
    }

    @GetMapping(value = "/padeiro/listagem")
    public String listaPadeiros(Model model){

        model.addAttribute("titulo", "Listagem de Padeiros");
        model.addAttribute("listagem", padeiroService.obterLista());

        return telaHome(model);
    }

    @GetMapping(value = "/produto/listagem")
    public String listaProdutos(Model model){

        model.addAttribute("titulo", "Listagem de Produtos");
        model.addAttribute("listagem", produtoService.obterLista());

        return telaHome(model);
    }
    @GetMapping(value = "/doce/listagem")
    public String listaDoces(Model model){

        model.addAttribute("titulo", "Listagem de Doces");
        model.addAttribute("listagem", doceService.obterLista());

        return telaHome(model);
    }
    @GetMapping(value = "/pao/listagem")
    public String listaPaes(Model model){

        model.addAttribute("titulo", "Listagem de Paes");
        model.addAttribute("listagem", paoService.obterLista());

        return telaHome(model);
    }
}
