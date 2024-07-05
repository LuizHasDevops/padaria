package br.edu.infnet.luiz.repository;

import br.edu.infnet.luiz.model.domain.Pao;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PaoRepository extends CrudRepository<Pao, Integer> {

    Collection<Pao> findAll(Sort by);
    Collection<Pao> findByIntegral(Boolean integral);
}
