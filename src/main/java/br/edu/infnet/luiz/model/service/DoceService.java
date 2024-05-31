package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.model.domain.Doce;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DoceService {

    private static Map<Integer, Doce> mapa = new HashMap<Integer, Doce>();
    private static Integer id = 0;

    public void incluir(Doce doce){
        doce.setId(++id);
        mapa.put(doce.getId(), doce);
    }

    public Collection<Doce> obterLista(){

        return mapa.values();
    }

    public Doce obterPorId(Integer id){

        return mapa.get(id);
    }

    public void excluir(Integer id){

        mapa.remove(id);
    }
}
