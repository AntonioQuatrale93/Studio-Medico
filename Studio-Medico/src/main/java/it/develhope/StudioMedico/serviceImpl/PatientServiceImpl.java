package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.PatientDto;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
import it.develhope.StudioMedico.entities.StatusRecord;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
import it.develhope.StudioMedico.repositories.PatientRepository;
import it.develhope.StudioMedico.repositories.PrenotationRepository;
import it.develhope.StudioMedico.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class implement all the method of the Interface of the Patient patientService
 */

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorsRepository doctorsRepository;

    @Autowired
    private PrenotationRepository prenotationRepository;

    /**
     * This API create and save a patient in his repository
     * @param patient
     * @return the saved patient;
     */
    @Override
    public ResponseEntity<Patient> createPatient(Patient patient) {
        patient.setStatus(StatusRecord.ACTIVE);
        patientRepository.save(patient);
        return ResponseEntity.status(201).body(patient);
    }

    /**
     * This API find a patient in the repository by Id
     * @param id
     * @return the founded patient
     */
    @Override
    public ResponseEntity<Optional<Patient>> getById(Long id) {
        if (patientRepository.existsById(id)) {
            return ResponseEntity.ok().body(patientRepository.findById(id));
        } else {
            return new ResponseEntity("no patient found with id :" + id, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This Api return the list of all the patient
     * @return the list of patient
     */
    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patientList = new ArrayList<>();
        patientRepository.findAll().forEach(patient -> {
            if(patient.getStatus() == StatusRecord.ACTIVE){
                patientList.add(patient);
            }
        });
        return patientList;
    }

    public List<Patient> getAllDeletedPatients() {
        List<Patient> patientList = new ArrayList<>();
        patientRepository.findAll().forEach(patient -> {
            if(patient.getStatus() == StatusRecord.DELETED){
                patientList.add(patient);
            }
        });
        return patientList;
    }


    /**
     * This API update the parameter of a patient found by ID
     * @param id
     * @param patientDto
     * @return a response entity with the updated  patient
     */
    @Override
    public ResponseEntity<Patient> updatePatient(Long id, PatientDto patientDto) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientRepository.findById(id).get();
            if (patientDto.getName() != null) {
                patient.setName(patientDto.getName());
            }
            if (patientDto.getSurname() != null) {
                patient.setSurname(patientDto.getSurname());
            }
            if (patientDto.getFiscalCode() != null) {
                patient.setFiscalCode(patientDto.getFiscalCode());
            }
            if (patientDto.getAge() != null) {
                patient.setAge(patientDto.getAge());
            }
            if (patientDto.getEmail() != null) {
                patient.setEmail(patientDto.getEmail());
            }
            if (patientDto.getPhoneNumber() != null) {
                patient.setPhoneNumber(patientDto.getPhoneNumber());
            }
            if (patientDto.getAddress() != null) {
                patient.setAddress(patientDto.getAddress());
            }
            Patient updatedPatient = patientRepository.saveAndFlush(patient);
            return ResponseEntity.ok(updatedPatient);
        } else {
            return new ResponseEntity("no patient found with id: " + id , HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This API assign a doctor to a patient
     * @param patientId
     * @param doctorId
     * @return a response entity with the updated patient
     */
    @Override
    public ResponseEntity<Patient> assignDoctor(Long patientId, Long doctorId) {
        if (patientRepository.existsById(patientId) && doctorsRepository.existsById(doctorId)) {
            Patient patient = patientRepository.findById(patientId).get();
            patient.setDoctor(doctorsRepository.findById(doctorId).get());
            Patient updatedPatient = patientRepository.saveAndFlush(patient);
            return ResponseEntity.ok(updatedPatient);
        }
        return new ResponseEntity("no patient found with id :" + patientId, HttpStatus.NOT_FOUND);
    }

    /**
     * This Api delete a patient found by Id
     * @param id
     * @return a ResponseEntity with the response code
     */
    @Override
    public ResponseEntity deleteById(Long id) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientRepository.findById(id).get();
            patient.setStatus(StatusRecord.DELETED);
            patientRepository.saveAndFlush(patient);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("no patient found with id :" + id, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This Api delete all the patients in the repository
     * @return a ResponseEntity with the response code
     */
    @Override
    public ResponseEntity deleteAll() {
        patientRepository.findAll().forEach(patient -> {
            patient.setStatus(StatusRecord.DELETED);
            patientRepository.saveAndFlush(patient);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * This Api is used by the patients to schedule a visit
     * @param prenotation
     * @param patientId
     * @param doctorId
     * @return prenotation
     */

    public ResponseEntity<Prenotation> bookVisit(Prenotation prenotation, long patientId, long doctorId)  {
        if (doctorsRepository.existsById(doctorId)) {
            prenotation.setDoctor(doctorsRepository.getReferenceById(doctorId));
        } else {
            return new ResponseEntity("doctor not found", HttpStatus.NOT_FOUND);
        }
        if (patientRepository.existsById(patientId)) {
            prenotation.setPatient(patientRepository.getReferenceById(patientId));
        } else {
            return new ResponseEntity("patient not found", HttpStatus.NOT_FOUND);
        }
        prenotation.setStatus(StatusRecord.ACTIVE);
        prenotation.setTranslatedStatus(prenotation.getStatus().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(prenotationRepository.save(prenotation));
    }
}

