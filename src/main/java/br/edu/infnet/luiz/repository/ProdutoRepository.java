package br.edu.infnet.luiz.repository;

import br.edu.infnet.luiz.model.domain.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
