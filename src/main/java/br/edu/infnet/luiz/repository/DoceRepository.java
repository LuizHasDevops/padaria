package br.edu.infnet.luiz.repository;

import br.edu.infnet.luiz.model.domain.Doce;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DoceRepository extends CrudRepository<Doce, Integer> {

    Collection<Doce> findByLight(boolean light);

    Collection<Doce> findAll(Sort by);

}
