package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {
}
