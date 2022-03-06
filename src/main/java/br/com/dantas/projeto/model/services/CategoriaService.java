package br.com.dantas.projeto.model.services;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.repositories.CategoriaRepository;
import br.com.dantas.projeto.model.services.exceptions.DataIntegrityException;
import br.com.dantas.projeto.model.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }
    }

    public Page<CategoriaEntity> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

}
