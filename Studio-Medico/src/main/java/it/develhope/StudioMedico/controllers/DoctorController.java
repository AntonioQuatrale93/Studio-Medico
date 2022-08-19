package it.develhope.StudioMedico.controllers;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.serviceImpl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorServiceImpl;



    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorServiceImpl.createDoctor(doctor);

    }

    @GetMapping
    public List<Doctor> getAllDoctor(){
        return doctorServiceImpl.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id){
        return doctorServiceImpl.getById(id);
    }

    @PatchMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto){
        return doctorServiceImpl.updateDoctor(id, doctorDto);
    }

    @DeleteMapping
    public void deleteDoctor(){
        doctorServiceImpl.deleteAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctorById(@PathVariable Long id){
        return doctorServiceImpl.deleteById(id);
    }
}