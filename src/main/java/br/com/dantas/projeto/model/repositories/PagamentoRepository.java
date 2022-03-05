package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Integer> {
}
