package it.develhope.StudioMedico.controllers;

import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.serviceImpl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;


    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.create(doctor);

    }

    @GetMapping
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctor();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id){
        return doctorService.getById(id);
    }

    @PatchMapping
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping
    public void deleteDoctor(){
        doctorService.deleteDoctor();
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
    }
}
