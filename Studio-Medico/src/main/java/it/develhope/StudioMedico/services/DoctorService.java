package it.develhope.StudioMedico.services;

import it.develhope.StudioMedico.entities.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor createDoctor();
    Doctor getById();
    List<Doctor> getAllDoctors();
    Doctor updateDoctor();
    void deleteById();
    void deleteAll();
}
