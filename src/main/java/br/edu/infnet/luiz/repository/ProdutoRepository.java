package br.edu.infnet.luiz.repository;

import br.edu.infnet.luiz.model.domain.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    Produto findByPeso(int peso);
    Collection<Produto> findByPadeiroId(Integer id);
}
