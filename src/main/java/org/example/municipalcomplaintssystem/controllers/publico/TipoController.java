package org.example.municipalcomplaintssystem.controllers.publico;

import org.example.municipalcomplaintssystem.db.entities.Tipo;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.example.municipalcomplaintssystem.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/tipo")
public class TipoController {

    @Autowired
    TipoService service;
    @Autowired
    DenunciaService denunciaService;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }
}
