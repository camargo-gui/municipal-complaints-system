package org.example.municipalcomplaintssystem.db.repositories;

import org.example.municipalcomplaintssystem.db.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query(value = "SELECT * FROM feedback WHERE den_id = :id", nativeQuery = true)
    Feedback findByIdDenuncia(Long id);
}
