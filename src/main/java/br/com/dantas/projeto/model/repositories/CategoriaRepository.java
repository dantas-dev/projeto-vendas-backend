package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

}
