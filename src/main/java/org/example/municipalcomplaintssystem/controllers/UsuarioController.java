package org.example.municipalcomplaintssystem.controllers;


import org.example.municipalcomplaintssystem.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping()
    ResponseEntity<Object> getAll(){return ResponseEntity.ok(service.buscarTodos());}
}
