package org.example.municipalcomplaintssystem.services;

import org.example.municipalcomplaintssystem.db.entities.Feedback;
import org.example.municipalcomplaintssystem.db.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository repository;

    public List<Feedback> buscarTodos() {
        return this.repository.findAll();
    }

    public Feedback buscarPorIdDenuncia(Long id) {
        return this.repository.findByIdDenuncia(id);
    }

    public void salvar(Feedback feedback) {
        this.repository.save(feedback);
    }

    public void deletar(int id) {
        this.repository.deleteById((long) id);
    }
}

