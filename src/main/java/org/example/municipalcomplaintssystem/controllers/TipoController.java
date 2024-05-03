package org.example.municipalcomplaintssystem.controllers;

import org.example.municipalcomplaintssystem.db.entities.Tipo;
import org.example.municipalcomplaintssystem.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tipo")
public class TipoController {

    @Autowired
    TipoService service;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping()
    public ResponseEntity<Object> post(@RequestBody Tipo tipo) {
        service.criar(tipo);
        return ResponseEntity.ok().body("{\"message\":\"Problema adicionado com sucesso\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().body("{\"message\":\"Problema deletado com sucesso\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable Long id, @RequestBody Tipo tipo) {
        service.atualizar(id, tipo);
        return ResponseEntity.ok().body("{\"message\":\"Problema atualizado com sucesso\"}");
    }
}
