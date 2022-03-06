package br.com.dantas.projeto.controllers;

import br.com.dantas.projeto.model.dto.ClienteDTO;
import br.com.dantas.projeto.model.dto.ClienteDTO;
import br.com.dantas.projeto.model.entities.ClienteEntity;
import br.com.dantas.projeto.model.entities.ClienteEntity;
import br.com.dantas.projeto.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteEntity> findById(@PathVariable Integer id) {
        ClienteEntity Cliente = service.findById(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteEntity> list = service.findAll();
        List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id) {
        ClienteEntity obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome")String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction) {
        Page<ClienteEntity> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }
}
