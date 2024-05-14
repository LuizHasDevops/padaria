package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.model.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class ProdutoService {

    private static Map<Integer, Produto> mapa = new HashMap<Integer, Produto>();
    private static Integer id = 0;

    public void incluir(Produto produto){
        produto.setId(++id);
        mapa.put(produto.getId(), produto);
    }

    public Collection<Produto> obterLista(){
        return mapa.values();
    }
}
