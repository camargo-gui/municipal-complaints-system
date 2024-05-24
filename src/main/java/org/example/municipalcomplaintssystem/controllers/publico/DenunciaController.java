package org.example.municipalcomplaintssystem.controllers.publico;

import org.example.municipalcomplaintssystem.db.entities.*;
import org.example.municipalcomplaintssystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/public/denuncia")
public class DenunciaController {

    @Autowired
    DenunciaService service;
    @Autowired
    OrgaoService orgaoService;
    @Autowired
    TipoService tipoService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByUserId(@PathVariable Long id) {
        List<Denuncia> denuncia = service.findByUserId(id);
        return ResponseEntity.ok(denuncia);
    }

    @PostMapping()
    public ResponseEntity<Object> criar(@RequestBody Denuncia denuncia) {
        Optional<Usuario> usuario = this.usuarioService.findById(Long.valueOf(denuncia.getUsuario().getId()));
        Optional<Tipo> tipo = this.tipoService.findById(Long.valueOf(denuncia.getTipo().getId()));
        Optional<Orgao> orgao = this.orgaoService.findById(Long.valueOf(denuncia.getOrgao().getId()));

        denuncia.setOrgao(orgao.get());
        denuncia.setUsuario(usuario.get());
        denuncia.setTipo(tipo.get());

        this.service.criar(denuncia);

        return ResponseEntity.ok().body("{\"message\":\"Denúncia adicionada com sucesso\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        Optional<Feedback> feedback = Optional.ofNullable(this.feedbackService.buscarPorIdDenuncia(id));
        feedback.ifPresent(value -> this.feedbackService.deletar((value.getId())));
        service.deletar(id);
        return ResponseEntity.ok().body("{\"message\":\"Denúncia deletada com sucesso\"}");
    }
}
