package it.develhope.StudioMedico.services;


import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface PatientService {



    Patient createPatient(Patient patient);


    Optional<Patient> getById(Long id);


    List<Patient> getAllPatient();


    Patient updatePatient(Long id, PatientDto patientDto);

    ResponseEntity deleteById(Long id);


    void deleteAll();
}
