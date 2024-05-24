package org.example.municipalcomplaintssystem.controllers.publico;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.db.entities.Feedback;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.example.municipalcomplaintssystem.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/public/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService service;

    @Autowired
    DenunciaService denunciaService;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<Feedback> feedback = Optional.ofNullable(this.service.buscarPorIdDenuncia(id));
        return ResponseEntity.ok(feedback);
    }
}
