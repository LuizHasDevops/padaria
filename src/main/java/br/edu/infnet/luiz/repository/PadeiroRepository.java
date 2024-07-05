package br.edu.infnet.luiz.repository;

import br.edu.infnet.luiz.model.domain.Padeiro;
import org.springframework.data.repository.CrudRepository;

public interface PadeiroRepository extends CrudRepository<Padeiro, Integer> {

    Padeiro findByCpf(String cpf);
}
