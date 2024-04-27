package org.example.municipalcomplaintssystem.services;

import org.example.municipalcomplaintssystem.db.entities.Tipo;
import org.example.municipalcomplaintssystem.db.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    TipoRepository repository;

    public List<Tipo> buscarTodos() {
        return this.repository.findAll();
    }
}
