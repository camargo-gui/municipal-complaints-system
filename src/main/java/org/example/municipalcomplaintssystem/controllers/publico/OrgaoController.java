package org.example.municipalcomplaintssystem.controllers.publico;


import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.db.entities.Orgao;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.example.municipalcomplaintssystem.services.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/public/orgao")
public class OrgaoController {

    @Autowired
    OrgaoService service;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }
}
