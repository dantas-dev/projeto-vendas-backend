package br.com.dantas.projeto.model.services;

import br.com.dantas.projeto.model.entities.PedidoEntity;
import br.com.dantas.projeto.model.repositories.PedidoRepository;
import br.com.dantas.projeto.model.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<PedidoEntity> findAll() {
        return repository.findAll();
    }

    public PedidoEntity findbyId(Integer id) {
        Optional<PedidoEntity> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + PedidoEntity.class.getName()));
    }

    public PedidoEntity insert(PedidoEntity obj) {
        obj.setId(null);
        return repository.save(obj);
    }


}
