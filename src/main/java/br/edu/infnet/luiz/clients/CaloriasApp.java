package br.edu.infnet.luiz.clients;

import br.edu.infnet.luiz.model.domain.Calorias;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(url = "https://caloriasporalimentoapi.herokuapp.com/api/calorias", name = "calorias")
public interface CaloriasApp {

    @GetMapping()
    List<Calorias> ObterCalorias(@RequestParam String descricao);
}
