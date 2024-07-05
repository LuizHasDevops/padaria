package br.edu.infnet.luiz.clients;

import br.edu.infnet.luiz.model.domain.Endereco;
import br.edu.infnet.luiz.model.domain.Estado;
import br.edu.infnet.luiz.model.domain.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "http://localhost:8081", name = "apiLuiz")
public interface AppLuizClient {

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep);

    @GetMapping(value = "/estados")
    public Collection<Estado> obterEstados();

    @GetMapping(value = "/{uf}/municipios")
    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf);

}
