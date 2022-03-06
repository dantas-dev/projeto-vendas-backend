package br.com.dantas.projeto.controllers;

import br.com.dantas.projeto.model.entities.PedidoEntity;
import br.com.dantas.projeto.model.entities.ProdutoEntity;
import br.com.dantas.projeto.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoEntity>> findAll() {
        List<PedidoEntity> obj = service.findAll();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoEntity> findById(@PathVariable Integer id) {
        PedidoEntity obj = service.findbyId(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PedidoEntity obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
