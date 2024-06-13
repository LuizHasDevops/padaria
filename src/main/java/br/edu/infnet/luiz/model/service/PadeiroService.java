package br.edu.infnet.luiz.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.luiz.repository.PadeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.luiz.model.domain.Padeiro;

@Service
public class PadeiroService {
    @Autowired
	private PadeiroRepository padeiroRepository;
	
	public void incluir(Padeiro padeiro) {
    	padeiroRepository.save(padeiro);
}
	public Collection<Padeiro> obterLista(){
        return (Collection<Padeiro>) padeiroRepository.findAll();
	}

    public Padeiro obterPorId(Integer id) {
        return padeiroRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        padeiroRepository.deleteById(id);
    }
    public long obterQtde() {
        return padeiroRepository.count();
    }
}
