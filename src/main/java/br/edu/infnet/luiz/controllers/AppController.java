package br.edu.infnet.luiz.controllers;

import br.edu.infnet.luiz.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/")
    public String telaHome(Model model){

        model.addAttribute("qtdePadeiro", padeiroService.obterQtde());
        model.addAttribute("qtdeProduto", produtoService.obterQtde());
        model.addAttribute("qtdeDoce", doceService.obterQtde());
        model.addAttribute("qtdePao", paoService.obterQtde());
        model.addAttribute("qtdeEndereco", enderecoService.obterQtde());

        model.addAttribute("estados", apiService.obterEstados());

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
    @GetMapping(value = "/endereco/listagem")
    public String listaEnderecos(Model model){

        model.addAttribute("titulo", "Listagem de Endereços");
        model.addAttribute("listagem", enderecoService.obterLista());

        return telaHome(model);
    }

    @GetMapping(value = "/estado/listagem")
    public String listaEstados(Model model){

        model.addAttribute("titulo", "Listagem de Estados");
        model.addAttribute("listagem", apiService.obterEstados());

        return telaHome(model);
    }

    @GetMapping(value = "/municipio/listagem")
    public String listaMunicipios(Model model, @RequestParam Integer uf){

        model.addAttribute("titulo", "Listagem de Municipios");
        model.addAttribute("listagem", apiService.obterMunicipios(uf));

        return telaHome(model);
    }
}
