package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
import it.develhope.StudioMedico.entities.PrenotationStatus;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
import it.develhope.StudioMedico.repositories.PatientRepository;
import it.develhope.StudioMedico.repositories.PrenotationRepository;
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

    @Autowired
    private PrenotationRepository prenotationRepository;


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
            if(patientDto.getName() != null){
                patient.setName(patientDto.getName());
            }
            if(patientDto.getSurname() != null){
                patient.setSurname(patientDto.getSurname());
            }
            if(patientDto.getFiscalCode() != null){
                patient.setFiscalCode(patientDto.getFiscalCode());
            }
            if(patientDto.getAge() != null){
                patient.setAge(patientDto.getAge());
            }
            if(patientDto.getEmail() != null){
                patient.setEmail(patientDto.getEmail());
            }
            if(patientDto.getPhoneNumber() != null){
                patient.setPhoneNumber(patientDto.getPhoneNumber());
            }
            if(patientDto.getAddress() != null){
                patient.setAddress(patientDto.getAddress());
            }
            Patient newPatient = patientRepository.saveAndFlush(patient);
            return newPatient;
        }
        return null;
    }

    @Override
    public Patient assignDoctor(Long patientId, Long doctorId) {
        if(patientRepository.existsById(patientId)){
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


    public Prenotation scheduleVisit(Prenotation prenotation, long patientId, long doctorId){
        if (doctorsRepository.existsById(doctorId)) {
            prenotation.setDoctor(doctorsRepository.getReferenceById(doctorId));
        } else {
            new Exception("doctor not found");
        }
        if (patientRepository.existsById(patientId)) {
            prenotation.setPatient(patientRepository.getReferenceById(patientId));
        } else {
            new Exception("patient not found");
        }
        prenotation.setPrenotationStatus(PrenotationStatus.BOOKED);
        prenotation.setStatusRecord(prenotation.getPrenotationStatus().toString());
        return prenotationRepository.save(prenotation);
    }
    }

