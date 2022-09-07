package it.develhope.StudioMedico.controllers;

import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
import it.develhope.StudioMedico.serviceImpl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 *This class permit to use the Api implemented in the PatientServiceImpl
 */
@RestController
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    private PatientServiceImpl patientServiceImpl;


    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return patientServiceImpl.createPatient(patient);
    }


    @GetMapping
    public List<Patient> getAllPatient() {
        return patientServiceImpl.getAllPatients();
    }

    @GetMapping("/deleted")
    public List<Patient> getAllDeletedPatient() {
        return patientServiceImpl.getAllDeletedPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> getPatientById(@PathVariable long id) {
        return patientServiceImpl.getById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody PatientDto patientDto) {
        return patientServiceImpl.updatePatient(id, patientDto);
    }

    @PatchMapping
    public ResponseEntity<Patient> assignDoctor(@RequestParam Long patientId, @RequestParam Long doctorId) {
        return patientServiceImpl.assignDoctor(patientId, doctorId);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity deletePatientById(@PathVariable long id) {
        return patientServiceImpl.deleteById(id);
    }

    @PatchMapping("/delete")
    public ResponseEntity deleteAllPatient() {
        return patientServiceImpl.deleteAll();
    }

    @PostMapping("/prenotation/{id}")
    public ResponseEntity<Prenotation> scheduleVisit(@PathVariable long id, @RequestParam long doctorId, @RequestBody Prenotation prenotation) {
        return patientServiceImpl.bookVisit(prenotation, id, doctorId);
    }


}
