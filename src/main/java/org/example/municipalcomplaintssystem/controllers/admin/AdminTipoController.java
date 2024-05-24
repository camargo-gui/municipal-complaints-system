package org.example.municipalcomplaintssystem.controllers.admin;

import org.example.municipalcomplaintssystem.db.entities.Tipo;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.example.municipalcomplaintssystem.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/tipo")
public class AdminTipoController {

    @Autowired
    TipoService service;

    @Autowired
    DenunciaService denunciaService;

    @PostMapping()
    public ResponseEntity<Object> post(@RequestBody Tipo tipo) {
        service.criar(tipo);
        return ResponseEntity.ok().body("{\"message\":\"Problema adicionado com sucesso\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        if(!denunciaService.findByTipoId(id).isEmpty()) {
            return ResponseEntity.badRequest().body("{\"message\":\"Não é possível deletar um tipo com denúncias associadas\"}");
        }
        service.deletar(id);
        return ResponseEntity.ok().body("{\"message\":\"Tipo deletado com sucesso\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable Long id, @RequestBody Tipo tipo) {
        service.atualizar(id, tipo);
        return ResponseEntity.ok().body("{\"message\":\"Tipo atualizado com sucesso\"}");
    }

}
