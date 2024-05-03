package org.example.municipalcomplaintssystem.controllers;


import org.example.municipalcomplaintssystem.db.entities.Orgao;
import org.example.municipalcomplaintssystem.services.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orgao")
public class OrgaoController {

    @Autowired
    OrgaoService service;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping()
    public ResponseEntity<Object> criar(@RequestBody Orgao orgao) {
        this.service.criar(orgao);
        return ResponseEntity.ok().body("{\"message\":\"Orgão adicionado com sucesso\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        this.service.deletar(id);
        return ResponseEntity.ok().body("{\"message\":\"Orgão deletado com sucesso\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable Long id, @RequestBody Orgao orgao) {
        this.service.atualizar(id, orgao);
        return ResponseEntity.ok().body("{\"message\":\"Orgão atualizado com sucesso\"}");
    }
}
