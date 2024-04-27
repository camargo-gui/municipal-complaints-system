package org.example.municipalcomplaintssystem.db.repositories;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long>{
}
