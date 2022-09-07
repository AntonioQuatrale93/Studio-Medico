package it.develhope.StudioMedico.services;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DoctorService {


    ResponseEntity<Doctor> createDoctor(Doctor doctor);

    ResponseEntity<Optional<Doctor>> getById(Long id);

    List<Doctor> getAllDoctors();

    List<Doctor> getAllDeletedDoctors();

    ResponseEntity<Doctor> updateDoctor(Long id, DoctorDto doctorDto);

    List<Prenotation> getAllDoctorPrenotation(Long id) throws Exception;

    List<Patient> getDoctorPatientList(Long doctorId) throws Exception;


    ResponseEntity<Doctor> assignSecretary(Long doctorId, Long secretaryId);

    ResponseEntity<?> deleteById(Long id);

    ResponseEntity<?> deleteAll();
}

