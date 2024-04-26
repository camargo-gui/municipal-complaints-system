package org.example.municipalcomplaintssystem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    public UsuarioController(){}

    @GetMapping("/")
    ResponseEntity<Object>getOne(){return ResponseEntity.ok("Olá, mundo");}
}
