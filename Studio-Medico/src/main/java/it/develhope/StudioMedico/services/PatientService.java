package it.develhope.StudioMedico.services;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Patient createPatient(Patient patient);

    Optional<Patient> getById(Long id);

    List<Patient> getAllPatients();

    Patient updatePatient(Long id, PatientDto patientDto);

    ResponseEntity deleteById(Long id);

    void deleteAll();
}
