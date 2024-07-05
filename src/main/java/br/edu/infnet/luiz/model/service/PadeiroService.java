package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.model.domain.Padeiro;
import br.edu.infnet.luiz.repository.PadeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PadeiroService {
    @Autowired
	private PadeiroRepository padeiroRepository;
	
	public void incluir(Padeiro padeiro) {
    	try{
            padeiroRepository.save(padeiro);
        } catch (Exception e){
            System.err.println("[ERROR] " + e.getMessage());
        }

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
    public Padeiro obterPorCPF(String cpf){
        return padeiroRepository.findByCpf(cpf);
    }
}
