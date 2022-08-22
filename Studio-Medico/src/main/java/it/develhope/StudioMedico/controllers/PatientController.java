package it.develhope.StudioMedico.controllers;

import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.serviceImpl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientServiceImpl;


    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientServiceImpl.createPatient(patient);
    }


    @GetMapping
    public List<Patient> getAllPatient() {
        return patientServiceImpl.getAllPatients();
    }


    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable long id) {
        return patientServiceImpl.getById(id);
    }

    @PatchMapping
    public Patient updatePatient(@PathVariable long id, @RequestBody PatientDto patientDto) {
        return patientServiceImpl.updatePatient(id, patientDto);
    }

    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable long id) {
        patientServiceImpl.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllPatient(){
        patientServiceImpl.deleteAll();
    }

}