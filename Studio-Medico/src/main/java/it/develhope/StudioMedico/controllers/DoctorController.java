package it.develhope.StudioMedico.controllers;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
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
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return doctorServiceImpl.createDoctor(doctor);

    }

    @GetMapping
    public List<Doctor> getAllDoctor() {
        return doctorServiceImpl.getAllDoctors();
    }

    @GetMapping("/deleted")
    public List<Doctor> getAllDeletedDoctor() {
        return doctorServiceImpl.getAllDeletedDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable Long id) {
        return doctorServiceImpl.getById(id);
    }

    @GetMapping("/list/patient/{doctorId}")
    public List<Patient> getDoctorPatients(@PathVariable Long doctorId) throws Exception {
        return doctorServiceImpl.getDoctorPatientList(doctorId);
    }

    @GetMapping("/list/prenotation/{doctorId}")
    public List<Prenotation> getPrenotation(@PathVariable Long doctorId) throws Exception {
        return doctorServiceImpl.getAllDoctorPrenotation(doctorId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
        return doctorServiceImpl.updateDoctor(id, doctorDto);
    }

    @PatchMapping
    public ResponseEntity<Doctor> assignSecretary(@RequestParam Long doctorId, @RequestParam Long secretaryId) {
        return doctorServiceImpl.assignSecretary(doctorId, secretaryId);
    }

    @PatchMapping("/delete")
    public ResponseEntity deleteDoctor() {
        return doctorServiceImpl.deleteAll();
    }

    @PatchMapping("delete/{id}")
    public ResponseEntity deleteDoctorById(@PathVariable Long id) {
        return doctorServiceImpl.deleteById(id);
    }
}