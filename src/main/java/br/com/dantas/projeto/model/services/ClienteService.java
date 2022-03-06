package br.com.dantas.projeto.model.services;

import br.com.dantas.projeto.model.dto.ClienteDTO;
import br.com.dantas.projeto.model.entities.ClienteEntity;
import br.com.dantas.projeto.model.entities.ClienteEntity;
import br.com.dantas.projeto.model.repositories.ClienteRepository;
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
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteEntity> findAll() {
        return repository.findAll();
    }

    public ClienteEntity findById(Integer id) {
        Optional<ClienteEntity> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ClienteEntity.class.getName()));
    }
    

    public ClienteEntity update(ClienteEntity obj) {
        ClienteEntity newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir um Cliente porque há entidades relacionadas");
        }
    }

    public Page<ClienteEntity> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public ClienteEntity fromDTO(ClienteDTO objDto) {
        return new ClienteEntity(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }

    private void updateData(ClienteEntity newObj, ClienteEntity obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}
