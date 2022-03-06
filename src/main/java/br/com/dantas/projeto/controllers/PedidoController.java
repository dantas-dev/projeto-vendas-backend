package br.com.dantas.projeto.controllers;

import br.com.dantas.projeto.model.entities.PedidoEntity;
import br.com.dantas.projeto.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
