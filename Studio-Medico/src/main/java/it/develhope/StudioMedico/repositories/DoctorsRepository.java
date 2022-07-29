package it.develhope.StudioMedico.repositories;

import it.develhope.StudioMedico.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctor, Long> {
}
