package org.example.municipalcomplaintssystem.controllers.admin;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.db.entities.Feedback;
import org.example.municipalcomplaintssystem.services.DenunciaService;
import org.example.municipalcomplaintssystem.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/admin/feedback")
public class AdminFeedbackController {

    @Autowired
    FeedbackService service;

    @Autowired
    DenunciaService denunciaService;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody Feedback feedback) {
        Optional<Denuncia> denuncia = this.denunciaService.findById(Long.valueOf(feedback.getDenuncia().getId()));
        feedback.setDenuncia(denuncia.get());

        this.service.salvar(feedback);

        return ResponseEntity.ok().body("{\"message\":\"Feedback adicionado com sucesso\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody Feedback feedback) {
        Optional<Feedback> feedbackOptional = Optional.ofNullable(this.service.buscarPorIdDenuncia(id));
        if (feedbackOptional.isPresent()) {
            feedback.setId(feedbackOptional.get().getId());
            this.service.salvar(feedback);
            return ResponseEntity.ok().body("{\"message\":\"Feedback atualizado com sucesso\"}");
        }
        return ResponseEntity.badRequest().body("{\"message\":\"Feedback não encontrado\"}");
    }
}
