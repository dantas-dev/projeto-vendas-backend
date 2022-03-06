package br.com.dantas.projeto.controllers;

import br.com.dantas.projeto.model.dto.ClienteDTO;
import br.com.dantas.projeto.model.entities.ClienteEntity;
import br.com.dantas.projeto.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
        ClienteEntity cliente = service.findById(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteEntity> list= service.findAll();
        List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClienteEntity obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ClienteEntity obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
