package org.example.municipalcomplaintssystem.services;


import org.example.municipalcomplaintssystem.db.entities.Usuario;
import org.example.municipalcomplaintssystem.db.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<Usuario> buscarTodos() {
        return this.repository.findAll();
    }

    public Usuario buscarPorEmail(String email) {
        return this.repository.findByEmail(email);
    }

    public Optional<Usuario> findById(Long id) {
        return this.repository.findById(id);
    }

    public void criar(Usuario usuario) {
        this.repository.save(usuario);
    }
}
