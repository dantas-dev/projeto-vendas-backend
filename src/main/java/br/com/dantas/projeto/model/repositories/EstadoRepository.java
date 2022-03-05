package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer> {

}
