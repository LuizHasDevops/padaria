package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.model.domain.Pao;
import br.edu.infnet.luiz.repository.PaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaoService {
   @Autowired
   private PaoRepository paoRepository;

    public void incluir(Pao pao){
        paoRepository.save(pao);
    }

    public Collection<Pao> obterLista(){
        return (Collection<Pao>) paoRepository.findAll();
    }

    public Pao obterPorId(Integer id) {
        return paoRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        paoRepository.deleteById(id);
    }
    public long obterQtde(){
        return paoRepository.count();
    }
}
