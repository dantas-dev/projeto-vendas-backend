package br.com.dantas.projeto.controllers;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaEntity> findById(@PathVariable Integer id) {
        CategoriaEntity categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> findAll() {
        List<CategoriaEntity> categorias = service.findAll();
        return ResponseEntity.ok().body(categorias);
    }
}
