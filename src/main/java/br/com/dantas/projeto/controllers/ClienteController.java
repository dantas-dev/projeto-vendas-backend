package br.com.dantas.projeto.controllers;

import br.com.dantas.projeto.model.entities.ClienteEntity;
import br.com.dantas.projeto.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<List<ClienteEntity>> findAll() {
        List<ClienteEntity> cliente = service.findAll();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cliente);
    }
}
