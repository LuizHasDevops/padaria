package br.edu.infnet.luiz.repository;

import br.edu.infnet.luiz.model.domain.Doce;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoceRepository extends CrudRepository<Doce, Integer> {
}
