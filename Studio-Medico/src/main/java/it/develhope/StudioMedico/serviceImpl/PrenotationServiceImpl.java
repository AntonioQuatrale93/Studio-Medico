package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.PrenotationDto;
import it.develhope.StudioMedico.entities.Prenotation;
import it.develhope.StudioMedico.entities.PrenotationStatus;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
import it.develhope.StudioMedico.repositories.PatientRepository;
import it.develhope.StudioMedico.repositories.PrenotationRepository;
import it.develhope.StudioMedico.services.PrenotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotationServiceImpl implements PrenotationService {

    @Autowired
    private PrenotationRepository prenotationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorsRepository doctorsRepository;


    @Override
    public ResponseEntity<Prenotation> createPrenotation(Prenotation prenotation, long doctorId, long patientId) {
        if (doctorsRepository.existsById(doctorId)) {
            prenotation.setDoctor(doctorsRepository.getReferenceById(doctorId));
        } else {
            return new ResponseEntity("doctor not found :",HttpStatus.NOT_FOUND);
        }
        if (patientRepository.existsById(patientId)) {
            prenotation.setPatient(patientRepository.getReferenceById(patientId));
        } else {
           return new ResponseEntity("patient not found :", HttpStatus.NOT_FOUND);
        }
        prenotation.setPrenotationStatus(PrenotationStatus.BOOKED);
        return ResponseEntity.ok(prenotationRepository.save(prenotation));
    }

    @Override
    public ResponseEntity<Optional<Prenotation>> getPrenotationById(long id) {
        if (prenotationRepository.existsById(id)){
            return ResponseEntity.ok().body(prenotationRepository.findById(id));
        }else {
            return new ResponseEntity("not found prenotation :",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Prenotation> getAllPrenotation() {
        return prenotationRepository.findAll();
    }

    @Override
    public ResponseEntity<Prenotation> updatePrenotation(long id, PrenotationDto prenotationDto) {
        if (prenotationRepository.existsById(id)) {
            Prenotation prenotation = prenotationRepository.findById(id).get();
            if (prenotationDto.getDate() != null) {
                prenotation.setDate(prenotationDto.getDate());
            }
            if (prenotationDto.getPrenotationStatus() != null) {
                prenotation.setPrenotationStatus(prenotationDto.getPrenotationStatus());
                prenotation.setStatusRecord(prenotation.getPrenotationStatus().toString());

            }
            if (prenotationDto.getDoctorId() != null) {
                prenotation.setDoctor(doctorsRepository.getReferenceById(prenotationDto.getDoctorId()));
            }
            if (prenotationDto.getPatientId() != null) {
                prenotation.setPatient(patientRepository.getReferenceById(prenotationDto.getPatientId()));
            }
            Prenotation updatedPrenotation = prenotationRepository.saveAndFlush(prenotation);
            return ResponseEntity.ok(updatedPrenotation);
        }
        return new ResponseEntity("secretary not found :" + id,HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity deletePrenotationById(long id) {
        if (prenotationRepository.existsById(id)) {
            prenotationRepository.deleteById(id);
            return ResponseEntity.status(201).body("deleteById success");
        } else {
          return new ResponseEntity("not found :" + id ,HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity deleteAllPrenotation() {
        prenotationRepository.deleteAll();
      return new ResponseEntity("deleteAllPrenotation :",HttpStatus.NO_CONTENT);
    }
}
