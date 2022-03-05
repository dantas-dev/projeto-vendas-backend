package br.com.dantas.projeto.model.repositories;

import br.com.dantas.projeto.model.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
}
