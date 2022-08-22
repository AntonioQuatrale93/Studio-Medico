package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.SecretaryDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Secretary;
import it.develhope.StudioMedico.repositories.SecretaryRepository;
import it.develhope.StudioMedico.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaryServiceImpl implements SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;


    @Override
    public Secretary createSecretary(Secretary secretary) {
        return secretaryRepository.save(secretary);
    }

    @Override
    public List<Secretary> getSecretary() {
        return secretaryRepository.findAll();
    }

    @Override
    public Secretary updateSecretary(Long id, SecretaryDto secretaryDto) {
        if (secretaryRepository.existsById(id)) {
            Secretary secretary = secretaryRepository.findById(id).get();
            secretary.setAddress(secretaryDto.getAddress());
            secretary.setPhoneNumber(secretaryDto.getPhoneNumber());
            Secretary newSecretary = secretaryRepository.saveAndFlush(secretary);
            return newSecretary;
        }
        return null;
    }

    @Override
    public void deleteSecretary() {
        secretaryRepository.deleteAll();
    }
}
