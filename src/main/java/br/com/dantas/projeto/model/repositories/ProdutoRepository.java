package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

}
