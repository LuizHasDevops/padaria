package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.model.domain.Doce;
import br.edu.infnet.luiz.repository.DoceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class DoceService {

   @Autowired
   private DoceRepository doceRepository;
    public void incluir(Doce doce) {
        try {
            doceRepository.save(doce);
        } catch (Exception e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }

    public Collection<Doce> obterLista(){
        return (Collection<Doce>) doceRepository.findAll();
    }

    public Collection<Doce> obterLista(String orderBy){
        return (Collection<Doce>) doceRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
        }

    public Doce obterPorId(Integer id){
        return doceRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id){
        doceRepository.deleteById(id);
    }
    public long obterQtde() {
        return doceRepository.count();
    }

    public Collection<Doce> obterListaLight(boolean light){
        return (Collection<Doce>) doceRepository.findByLight(light);
    }
}
