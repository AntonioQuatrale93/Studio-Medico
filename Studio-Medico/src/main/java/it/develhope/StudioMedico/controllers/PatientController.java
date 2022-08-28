package it.develhope.StudioMedico.controllers;


import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.repositories.PatientRepository;
import it.develhope.StudioMedico.serviceImpl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientServiceImpl;


    @PostMapping
    public Patient createPatinet(@RequestBody Patient patient){
       return patientServiceImpl.createPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatiet(){

    return patientServiceImpl.getAllPatient();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id){
        return patientServiceImpl.getById(id);
    }

    @PatchMapping("/{id}")
    public Patient updatePatient(@RequestBody PatientDto patientDto, @PathVariable Long id){
        return patientServiceImpl.updatePatient(id, patientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        return patientServiceImpl.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        patientServiceImpl.deleteAll();
    }

}
