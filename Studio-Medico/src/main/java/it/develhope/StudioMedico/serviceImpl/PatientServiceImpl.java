package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.repositories.PatientRepository;
import it.develhope.StudioMedico.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public ResponseEntity<Patient> createPatient(Patient patient) {
        patientRepository.save(patient);
        return ResponseEntity.status(201).body(patient);
    }

    @Override
    public ResponseEntity<Optional<Patient>> getById(Long id) {
         if (patientRepository.existsById(id)){
             return ResponseEntity.ok().body(patientRepository.findById(id));
         }else {
             return new  ResponseEntity("not found id patient :",HttpStatus.NOT_FOUND);
         }
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public ResponseEntity<Patient> updatePatient(Long id, PatientDto patientDto) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientRepository.findById(id).get();
            patient.setAddress(patientDto.getAddress());
            patient.setPhoneNumber(patientDto.getPhoneNumber());
            Patient newPatient = patientRepository.saveAndFlush(patient);
            return ResponseEntity.ok(newPatient);
        }else {
            return new ResponseEntity("patient not found :", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity deleteById(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return ResponseEntity.status(201).body("deleteById success");
        } else {
            return new ResponseEntity(" not found :" + id,HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity deleteAll() {
        patientRepository.deleteAll();
        return new ResponseEntity("deleteAllPatient : ",HttpStatus.NO_CONTENT);
    }
}
