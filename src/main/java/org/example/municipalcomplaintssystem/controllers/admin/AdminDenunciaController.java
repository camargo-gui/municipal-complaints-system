package org.example.municipalcomplaintssystem.controllers.admin;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin/denuncia")
public class AdminDenunciaController {

    @Autowired
    DenunciaService service;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        List<Denuncia> denuncia = service.buscarTodos();
        return ResponseEntity.ok(denuncia);
    }
}
