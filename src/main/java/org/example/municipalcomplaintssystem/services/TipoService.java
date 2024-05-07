package org.example.municipalcomplaintssystem.services;

import org.example.municipalcomplaintssystem.db.entities.Tipo;
import org.example.municipalcomplaintssystem.db.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    @Autowired
    TipoRepository repository;

    public List<Tipo> buscarTodos() {
        return this.repository.findAll();
    }

    public void criar(Tipo tipo) {
        this.repository.save(tipo);
    }

    public void deletar(Long id) {
        this.repository.deleteById(id);
    }

    public Optional<Tipo> findById(Long id) {
        return this.repository.findById(id);
    }

    public void atualizar(Long id, Tipo tipo) {
        Tipo tipoAtualizado = this.repository.findById(id).get();
        tipoAtualizado.setNome(tipo.getNome());
        this.repository.save(tipoAtualizado);
    }
}
