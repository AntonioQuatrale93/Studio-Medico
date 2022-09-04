package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.SecretaryDto;
import it.develhope.StudioMedico.entities.Secretary;
import it.develhope.StudioMedico.repositories.SecretaryRepository;
import it.develhope.StudioMedico.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaryServiceImpl implements SecretaryService {


    @Autowired
    private SecretaryRepository secretaryRepository;


    @Override
    public ResponseEntity<Secretary> createSecretary(Secretary secretary) {
       secretaryRepository.save(secretary);
        return new ResponseEntity("success created secretary",HttpStatus.CREATED);
    }

    @Override
    public List<Secretary> getSecretary() {
        return secretaryRepository.findAll();
    }

    @Override
    public ResponseEntity<Secretary> updateSecretary(Long id, SecretaryDto secretaryDto)  {
       if (secretaryRepository.existsById(id)){
           Secretary secretary = secretaryRepository.findById(id).get();
           secretary.setAddress(secretaryDto.getAddress());
           secretary.setPhoneNumber(secretaryDto.getPhoneNumber());
           Secretary newSecretary = secretaryRepository.saveAndFlush(secretary);
           return ResponseEntity.ok(newSecretary);
       }else {
         return new ResponseEntity("secretary not found :" + id,HttpStatus.NOT_FOUND);
       }
    }

    @Override
    public ResponseEntity deleteSecretary() {
        secretaryRepository.deleteAll();
        return new ResponseEntity("deleteAll :", HttpStatus.OK);
    }
}
