package it.develhope.StudioMedico.repositories;

import it.develhope.StudioMedico.entities.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
}
