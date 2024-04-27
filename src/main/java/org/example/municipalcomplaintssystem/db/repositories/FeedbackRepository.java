package org.example.municipalcomplaintssystem.db.repositories;

import org.example.municipalcomplaintssystem.db.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
