package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.clients.AppLuizClient;
import br.edu.infnet.luiz.model.domain.Endereco;
import br.edu.infnet.luiz.model.domain.Estado;
import br.edu.infnet.luiz.model.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class ApiService {

    @Autowired
    private AppLuizClient apiLuizClient;

    public Endereco obterPorCep(String cep) {
        return apiLuizClient.obterEnderecoPorCep(cep);
    }

    public Collection<Estado> obterEstados(){
        return apiLuizClient.obterEstados();
    }

    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf){
        return apiLuizClient.obterMunicipios(uf);
    }
}
