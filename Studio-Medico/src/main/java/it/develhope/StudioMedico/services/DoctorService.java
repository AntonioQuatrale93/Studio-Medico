package it.develhope.StudioMedico.services;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DoctorService {


    ResponseEntity<Doctor> createDoctor(Doctor doctor);

    ResponseEntity<Optional<Doctor>> getById(Long id);

    List<Doctor> getAllDoctors();

    ResponseEntity<Doctor> updateDoctor(Long id, DoctorDto doctorDto);

    ResponseEntity deleteById(Long id);

    ResponseEntity deleteAll();
}

