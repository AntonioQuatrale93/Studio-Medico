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
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> getById(Long id) {
       try {
           if (patientRepository.existsById(id)){
               patientRepository.findById(id);
               System.out.println("id selezionato esiste");
           }else {
               throw new Exception("impossibile trovare id selezionato " + (HttpStatus.NOT_FOUND));
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Long id, PatientDto patientDto) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientRepository.findById(id).get();
            patient.setAddress(patientDto.getAddress());
            patient.setAge(patientDto.getAge());
            patient.setPhoneNumber(patientDto.getPhone_Number());
            patient.setName(patientDto.getName());
            patient.setSurname(patientDto.getSurname());
            patient.setFiscalCode(patientDto.getFiscalCode());
            Patient newPatient = patientRepository.saveAndFlush(patient);
            return newPatient;
        }
        return null;
    }

    @Override
    public ResponseEntity deleteById(Long id) {
         try {
             if (patientRepository.existsById(id)){
                  patientRepository.deleteById(id);
                  ResponseEntity.status(200);
             }else {
                 throw new Exception("impossibile cancellare id selezionato");
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteAll() {
      patientRepository.deleteAll();
    }
}
