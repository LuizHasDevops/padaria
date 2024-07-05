package br.edu.infnet.luiz.clients;

import br.edu.infnet.luiz.model.domain.Calorias;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://caloriasporalimentoapi.herokuapp.com/api/calorias", name = "calorias")
public interface CaloriasApp {

    @GetMapping(value = "/{descricao}")
    public Calorias ObterCalorias(@RequestParam String descricao);
}
