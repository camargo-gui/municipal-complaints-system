package org.example.municipalcomplaintssystem.services;

import org.example.municipalcomplaintssystem.db.entities.Orgao;
import org.example.municipalcomplaintssystem.db.repositories.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgaoService {

    @Autowired
    OrgaoRepository repository;

    public List<Orgao> buscarTodos() {
        return this.repository.findAll();
    }
}
