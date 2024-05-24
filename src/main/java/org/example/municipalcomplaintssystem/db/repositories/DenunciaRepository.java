package org.example.municipalcomplaintssystem.db.repositories;

import org.example.municipalcomplaintssystem.db.entities.Denuncia;
import org.example.municipalcomplaintssystem.db.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long>{
    @Query(value = "SELECT * FROM denuncia WHERE usu_id = :id", nativeQuery = true)
    List<Denuncia> findByUserId(Long id);

    @Query(value = "SELECT * FROM denuncia WHERE org_id = :id", nativeQuery = true)
    List<Denuncia> findByOrgaoId(Long id);

    @Query(value = "SELECT * FROM denuncia WHERE tip_id = :id", nativeQuery = true)
    List<Denuncia> findByTipoId(Long id);
}
