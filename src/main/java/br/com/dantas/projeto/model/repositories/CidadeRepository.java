package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<CidadeEntity, Integer> {

}
