package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.PrenotationDto;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
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
    public Prenotation createPrenotation(Prenotation prenotation, long doctorId, long patientId ) {
        prenotation.setDoctor(doctorsRepository.findById(doctorId).get());
        prenotation.setPatient(patientRepository.findById(patientId).get());
        return prenotationRepository.save(prenotation);
    }

    @Override
    public Optional<Prenotation> getPrenotationById(long id) {
        return prenotationRepository.findById(id);
    }

    @Override
    public List<Prenotation> getAllPrenotation() {
        return prenotationRepository.findAll();
    }

    @Override
    public Prenotation updatePrenotation(long id, PrenotationDto prenotationDto) {
        if (prenotationRepository.existsById(id)) {
            Prenotation prenotation = prenotationRepository.findById(id).get();
            if( prenotationDto.getDate() != null) {
                prenotation.setDate(prenotationDto.getDate());
            }
            if(prenotationDto.getPrenotationStatus() != null) {
                prenotation.setPrenotationStatus(prenotationDto.getPrenotationStatus());
            }
            if(prenotationDto.getPatientId() != null) {
                prenotation.setPatient(patientRepository.findById(prenotationDto.getPatientId()).get());
            }
            if(prenotationDto.getDoctorId() != null) {
                prenotation.setDoctor(doctorsRepository.findById(prenotationDto.getDoctorId()).get());
            }
            Prenotation newPrenotation = prenotationRepository.saveAndFlush(prenotation);
            return newPrenotation;
        }
        return null;
    }


    @Override
    public ResponseEntity deletePrenotationById(long id) {
        if (prenotationRepository.existsById(id)) {
            prenotationRepository.deleteById(id);
            return null;
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteAllPrenotation() {
        prenotationRepository.deleteAll();

    }
}
