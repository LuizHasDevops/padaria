package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.model.domain.Pao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaoService {

    private static Map<Integer, Pao> mapa = new HashMap<Integer, Pao>();
    private static Integer id = 0;

    public void incluir(Pao pao){
        pao.setId(++id);
        mapa.put(pao.getId(), pao);
    }

    public Collection<Pao> obterLista(){
        return mapa.values();
    }
}
