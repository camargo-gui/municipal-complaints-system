package org.example.municipalcomplaintssystem.controllers.publico;


import org.example.municipalcomplaintssystem.db.entities.Usuario;
import org.example.municipalcomplaintssystem.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping()
    ResponseEntity<Object> getAll(){return ResponseEntity.ok(service.buscarTodos());}

    @PostMapping()
    ResponseEntity<Object> criar(@RequestBody Usuario usuario){
        usuario.setNivel(2);
        service.criar(usuario);
        return ResponseEntity.ok().body("{\"message\":\"Usuário adicionado com sucesso\"}");
    }
}
