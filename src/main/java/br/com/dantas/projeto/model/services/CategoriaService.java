package br.com.dantas.projeto.model.services;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.repositories.CategoriaRepository;
import br.com.dantas.projeto.model.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaEntity findById(Integer id) {
        Optional<CategoriaEntity> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaEntity.class.getName()));
    }

    public List<CategoriaEntity> findAll() {
        return repository.findAll();
    }

    public CategoriaEntity insert(CategoriaEntity obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public CategoriaEntity update(CategoriaEntity obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

}
