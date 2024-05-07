package org.example.municipalcomplaintssystem.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.municipalcomplaintssystem.db.entities.Usuario;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    @Query(value = "SELECT * FROM usuario WHERE usu_email = :email", nativeQuery = true)
    Usuario findByEmail(String email);
}
