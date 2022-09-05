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

    /**
     * Create entity prenotation
     * @param prenotation
     * @param doctorId
     * @param patientId
     * @return prenotation
     */
    @Override
    public ResponseEntity<Prenotation> createPrenotation(Prenotation prenotation, long doctorId, long patientId) {
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
        prenotation.setPrenotationStatus(PrenotationStatus.BOOKED);
        return ResponseEntity.ok(prenotationRepository.save(prenotation));
    }

    /**
     * Return the prenotation by id
     * @param id
     * @return prenotation
     */
    @Override
    public ResponseEntity<Optional<Prenotation>> getPrenotationById(long id) {
        if (prenotationRepository.existsById(id)) {
            return ResponseEntity.ok().body(prenotationRepository.findById(id));
        } else {
            return new ResponseEntity("Prenotation with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Return all the prenotations
     * @return prenotations
     */
    @Override
    public List<Prenotation> getAllPrenotation() {
        return prenotationRepository.findAll();
    }


    /**
     * Modifica un entità prenotation
     * @param id
     * @param prenotationDto
     * @return updatedPrenotation
     */
    @Override
    public ResponseEntity<Prenotation> updatePrenotation(long id, PrenotationDto prenotationDto) {
        if (prenotationRepository.existsById(id)) {
            Prenotation prenotation = prenotationRepository.findById(id).get();
            if (prenotationDto.getDate() != null) {
                prenotation.setDate(prenotationDto.getDate());
            }
            if (prenotationDto.getTime() != null) {
                prenotation.setTime(prenotationDto.getTime());
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
        return new ResponseEntity("Prenotation with id " + id + " not found", HttpStatus.NOT_FOUND);
    }

    /**
     * Elimina un entità prenotation tramite id
     * @param id
     */
    @Override
    public ResponseEntity deletePrenotationById(long id) {
        if (prenotationRepository.existsById(id)) {
            prenotationRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("Prenotation with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Elimina tutte le entità prenotation
     */
    @Override
    public ResponseEntity deleteAllPrenotation() {
        prenotationRepository.deleteAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
