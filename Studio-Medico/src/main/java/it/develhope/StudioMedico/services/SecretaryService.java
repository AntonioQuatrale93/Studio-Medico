package it.develhope.StudioMedico.services;


import it.develhope.StudioMedico.dto.SecretaryDto;
import it.develhope.StudioMedico.entities.Secretary;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface SecretaryService {

    Secretary createSecretary(Secretary secretary);

    List<Secretary> getSecretary();

    Secretary updateSecretary(Long id, SecretaryDto secretaryDto);

    void deleteSecretary();

}

