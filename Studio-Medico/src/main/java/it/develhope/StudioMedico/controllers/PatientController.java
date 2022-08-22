package it.develhope.StudioMedico.controllers;


import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;


    @PostMapping
    public Patient postPatient(@RequestBody Patient patient){

        return patientRepository.saveAndFlush(patient);
    }

    @GetMapping
    public List<Patient> getPatient(){

        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getSingle(@PathVariable Long id){

        Optional<Patient> patientOptional = patientRepository.findById(id);

        try {

            if (patientRepository.existsById(id)){
                System.out.println("Id selezionato esiste");
            }else {
                throw new Exception("Id selezionato non esiste");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return patientOptional;
    }

    @PutMapping("/{id}")
    public Patient putPatient(@RequestBody Patient patient){

        Patient patient1 = patientRepository.saveAndFlush(patient);

        try {
            if (patient1.equals(patient)){
                throw new Exception("parametro modificato");
            }else {
                System.out.println("impossibile aggiornare la macchina");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return patient1;
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable long id){

        try {
            if (patientRepository.existsById(id)){
                patientRepository.deleteById(id);
                System.out.println("Id cancellato correttamente");
            }else {
                throw new Exception("Id selezionato non esiste");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @DeleteMapping
    public void deleteAllPatient(@RequestParam List<Long> patients){

        patientRepository.deleteAllById(patients);
    }
}
