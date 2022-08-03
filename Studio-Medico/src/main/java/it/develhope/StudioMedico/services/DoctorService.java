package it.develhope.StudioMedico.services;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DoctorService {


    Doctor createDoctor(Doctor doctor);

    Optional<Doctor> getById(Long id);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(Long id, DoctorDto doctorDto);
    ResponseEntity deleteById(Long id);
    void deleteAll();
}
