package org.example.municipalcomplaintssystem.controllers.admin;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.db.entities.Orgao;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.example.municipalcomplaintssystem.services.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/orgao")
public class AdminOrgaoController {

    @Autowired
    OrgaoService service;

    @Autowired
    DenunciaService denunciaService;


    @PostMapping()
    public ResponseEntity<Object> criar(@RequestBody Orgao orgao) {
        this.service.criar(orgao);
        return ResponseEntity.ok().body("{\"message\":\"Orgão adicionado com sucesso\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        List<Denuncia> denuncias = denunciaService.findByOrgaoId(id);
        if(!denuncias.isEmpty()) {
            return ResponseEntity.badRequest().body("{\"message\":\"Não é possível deletar um orgão com denúncias associadas\"}");
        }
        this.service.deletar(id);
        return ResponseEntity.ok().body("{\"message\":\"Orgão deletado com sucesso\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable Long id, @RequestBody Orgao orgao) {
        this.service.atualizar(id, orgao);
        return ResponseEntity.ok().body("{\"message\":\"Orgão atualizado com sucesso\"}");
    }
}
