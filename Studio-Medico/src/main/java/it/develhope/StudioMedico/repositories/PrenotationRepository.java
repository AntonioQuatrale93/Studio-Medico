package it.develhope.StudioMedico.repositories;

import it.develhope.StudioMedico.entities.Prenotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotationRepository extends JpaRepository<Prenotation, Long> {
}
