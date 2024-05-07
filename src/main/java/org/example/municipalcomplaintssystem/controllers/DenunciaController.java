package org.example.municipalcomplaintssystem.controllers;

import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/denuncia")
public class DenunciaController {

    @Autowired
    DenunciaService service;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }
}
