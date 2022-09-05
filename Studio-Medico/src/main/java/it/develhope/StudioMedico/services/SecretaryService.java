package it.develhope.StudioMedico.services;


import it.develhope.StudioMedico.dto.SecretaryDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Secretary;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface SecretaryService {


    ResponseEntity<Secretary> createSecretary(Secretary secretary);

    List<Secretary> getSecretary();

    ResponseEntity<Secretary> updateSecretary(Long id, SecretaryDto secretaryDto);

    List<Doctor> getAllDoctor(Long id) throws Exception;

    ResponseEntity<?> deleteSecretary();

}

