package br.com.dantas.projeto.controllers;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaEntity> findById(@PathVariable Integer id) {
        CategoriaEntity categoria = service.findById(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> findAll() {
        List<CategoriaEntity> categorias = service.findAll();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(categorias);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CategoriaEntity categoria){
        categoria = service.insert(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody CategoriaEntity obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
