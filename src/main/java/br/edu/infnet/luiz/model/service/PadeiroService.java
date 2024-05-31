package br.edu.infnet.luiz.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.luiz.model.domain.Padeiro;

@Service
public class PadeiroService {

	private static Map<Integer, Padeiro> mapa = new HashMap<Integer, Padeiro>();
	private static Integer id = 0;
	
	public void incluir(Padeiro padeiro) {
    	padeiro.setId(++id);
	    mapa.put(padeiro.getId(), padeiro);
}
	public Collection<Padeiro> obterLista(){

        return mapa.values();
	}

    public Padeiro obterPorId(Integer id) {
        return mapa.get(id);
    }

    public void excluir(Integer id) {
        mapa.remove(id);
    }
}
