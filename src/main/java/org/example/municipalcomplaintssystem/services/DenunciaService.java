package org.example.municipalcomplaintssystem.services;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.db.repositories.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenunciaService {

    @Autowired
    DenunciaRepository repository;

    public List<Denuncia> buscarTodos() {
        return this.repository.findAll();
    }

    public void criar(Denuncia denuncia) {
        this.repository.save(denuncia);
    }

    public void deletar(Long id) {
        this.repository.deleteById(id);
    }

    public List<Denuncia> findByUserId(Long id) {
        return this.repository.findByUserId(id);
    }

    public List<Denuncia> findByOrgaoId(Long id) {
        return this.repository.findByOrgaoId(id);
    }

    public List<Denuncia> findByTipoId(Long id) {
        return this.repository.findByTipoId(id);
    }

    public Optional<Denuncia> findById(Long id) {
        return this.repository.findById(id);
    }
}
