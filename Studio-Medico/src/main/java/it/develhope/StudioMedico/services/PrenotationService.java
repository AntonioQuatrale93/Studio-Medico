package it.develhope.StudioMedico.services;

import it.develhope.StudioMedico.dto.PrenotationDto;
import it.develhope.StudioMedico.entities.Prenotation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PrenotationService {


     Prenotation createPrenotation(Prenotation prenotation, long patientId, long doctorId);

     Optional<Prenotation> getPrenotationById(long id);

     List<Prenotation> getAllPrenotation();

     Prenotation updatePrenotation(long id, PrenotationDto prenotationDto);

     ResponseEntity deletePrenotationById(long id);

     void deleteAllPrenotation();


}
