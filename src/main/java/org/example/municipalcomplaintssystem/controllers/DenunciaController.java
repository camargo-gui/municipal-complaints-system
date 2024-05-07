package org.example.municipalcomplaintssystem.controllers;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.db.entities.Orgao;
import org.example.municipalcomplaintssystem.db.entities.Tipo;
import org.example.municipalcomplaintssystem.db.entities.Usuario;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.example.municipalcomplaintssystem.services.OrgaoService;
import org.example.municipalcomplaintssystem.services.TipoService;
import org.example.municipalcomplaintssystem.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/denuncia")
public class DenunciaController {

    @Autowired
    DenunciaService service;
    @Autowired
    OrgaoService orgaoService;
    @Autowired
    TipoService tipoService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        List <Denuncia> denuncia = service.buscarTodos();
        return ResponseEntity.ok(denuncia);
    }

    @PostMapping()
    public ResponseEntity<Object> criar(@RequestBody Denuncia denuncia) {
        Optional<Usuario> usuario = this.usuarioService.findById(Long.valueOf(denuncia.getUsuarioId().getId()));
        Optional<Tipo> tipo = this.tipoService.findById(Long.valueOf(denuncia.getTipoId().getId()));
        Optional<Orgao> orgao = this.orgaoService.findById(Long.valueOf(denuncia.getOrgao().getId()));

        denuncia.setOrgao(orgao.get());
        denuncia.setUsuarioId(usuario.get());
        denuncia.setTipoId(tipo.get());

        this.service.criar(denuncia);

        return ResponseEntity.ok().body("{\"message\":\"Denúncia adicionada com sucesso\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().body("{\"message\":\"Denúncia deletada com sucesso\"}");
    }
}
