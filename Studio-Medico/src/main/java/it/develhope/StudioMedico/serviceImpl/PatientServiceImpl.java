package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
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

    @Autowired
    private DoctorsRepository doctorsRepository;


    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> getById(Long id) {

        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Long id, PatientDto patientDto) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientRepository.findById(id).get();
            patient.setAddress(patientDto.getAddress());
            patient.setPhoneNumber(patientDto.getPhoneNumber());
            Patient newPatient = patientRepository.saveAndFlush(patient);
            return newPatient;
        }
        return null;
    }

    @Override
    public Patient assignDoctor(Long patientId, Long doctorId) {
        if(doctorsRepository.existsById(doctorId)){
            Patient patient = patientRepository.findById(patientId).get();
            patient.setDoctor(doctorsRepository.findById(doctorId).get());
            Patient updatedPatient = patientRepository.saveAndFlush(patient);
            return updatedPatient;
        }
        return null;
    }


    @Override
    public ResponseEntity deleteById(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return null;
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteAll() {
        patientRepository.deleteAll();
    }
}
