package it.develhope.StudioMedico.services;

import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    ResponseEntity<Patient> createPatient(Patient patient);

    ResponseEntity<Optional<Patient>> getById(Long id);

    List<Patient> getAllPatients();

    ResponseEntity<Patient> updatePatient(Long id, PatientDto patientDto);

    ResponseEntity deleteById(Long id);

    ResponseEntity deleteAll();
}
