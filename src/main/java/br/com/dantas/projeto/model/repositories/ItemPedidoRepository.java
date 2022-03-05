package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
