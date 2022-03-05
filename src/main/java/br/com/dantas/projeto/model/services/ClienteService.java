package br.com.dantas.projeto.model.services;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.entities.ClienteEntity;
import br.com.dantas.projeto.model.repositories.ClienteRepository;
import br.com.dantas.projeto.model.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteEntity> findAll() {
        return repository.findAll();
    }

    public ClienteEntity findById(Integer id) {
        Optional<ClienteEntity> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaEntity.class.getName()));
    }
}
