package br.com.dantas.projeto.model.services;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaEntity findById(Integer id) {
        Optional<CategoriaEntity> obj = repository.findById(id);
        return obj.orElse(null);
    }

}
