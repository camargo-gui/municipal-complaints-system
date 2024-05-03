package org.example.municipalcomplaintssystem.services;

import org.example.municipalcomplaintssystem.db.entities.Orgao;
import org.example.municipalcomplaintssystem.db.repositories.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgaoService {

    @Autowired
    OrgaoRepository repository;

    public List<Orgao> buscarTodos() {
        return this.repository.findAll();
    }

    public void criar(Orgao orgao) {
        this.repository.save(orgao);
    }

    public void deletar(Long id) {
        this.repository.deleteById(id);
    }

    public Optional<Orgao> findById(Long id) {
        return this.repository.findById(id);
    }

    public void atualizar(Long id, Orgao orgao) {
        Orgao orgaoAtualizado = this.repository.findById(id).get();
        orgaoAtualizado.setNome(orgao.getNome());
        this.repository.save(orgaoAtualizado);
    }
}
