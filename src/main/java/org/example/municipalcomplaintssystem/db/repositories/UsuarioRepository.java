package org.example.municipalcomplaintssystem.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.municipalcomplaintssystem.db.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
