package it.develhope.StudioMedico.services;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DoctorService {


    Doctor createDoctor(Doctor doctor);

    Optional<Doctor> getById(Long id);

    List<Doctor> getAllDoctors();

    List<Prenotation> getAllPrenotation(Long id) throws Exception;

    List<Patient> getPatientList(Long doctorId) throws Exception;

    Doctor updateDoctor(Long id, DoctorDto doctorDto);

    Doctor assignSecretary(Long doctorId, Long secretaryId);

    ResponseEntity deleteById(Long id);

    void deleteAll();
}

