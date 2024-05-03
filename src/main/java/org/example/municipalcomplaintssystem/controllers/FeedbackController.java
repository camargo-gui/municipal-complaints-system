package org.example.municipalcomplaintssystem.controllers;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.db.entities.Feedback;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.example.municipalcomplaintssystem.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService service;

    @Autowired
    DenunciaService denunciaService;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody Feedback feedback) {
        Optional<Denuncia> denuncia = this.denunciaService.findById(Long.valueOf(feedback.getDenuncia().getId()));
        feedback.setDenuncia(denuncia.get());

        this.service.criar(feedback);

        return ResponseEntity.ok().body("{\"message\":\"Feedback adicionado com sucesso\"}");
    }
}
