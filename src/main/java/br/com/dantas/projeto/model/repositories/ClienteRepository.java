package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
