package br.edu.infnet.luiz.model.service;

import br.edu.infnet.luiz.clients.AppLuizClient;
import br.edu.infnet.luiz.model.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EstadoService {

    @Autowired
    private AppLuizClient appLuizClient;

    public Collection<Estado> obterLista(){

        return appLuizClient.obterEstados();
    }
}
