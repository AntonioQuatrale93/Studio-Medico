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
    public List<Doctor> getAllDoctor(Long id) throws Exception {
        if(secretaryRepository.existsById(id)){
            return secretaryRepository.findById(id).get().getDoctorList();
        } throw new Exception("secretary not found");
    }

    @Override
    public Secretary updateSecretary(Long id, SecretaryDto secretaryDto) {
        if (secretaryRepository.existsById(id)) {
            Secretary secretary = secretaryRepository.findById(id).get();
            if(secretaryDto.getName() != null){
                secretary.setName(secretaryDto.getName());
            }
            if(secretaryDto.getSurname() != null){
                secretary.setSurname(secretaryDto.getSurname());
            }
            if(secretaryDto.getFiscalCode() != null){
                secretary.setFiscalCode(secretaryDto.getFiscalCode());
            }
            if(secretaryDto.getEmail() != null){
                secretary.setEmail(secretaryDto.getEmail());
            }
            if(secretaryDto.getAddress() != null){
                secretary.setAddress(secretaryDto.getAddress());
            }
            if(secretaryDto.getPhoneNumber() != null){
                secretary.setPhoneNumber(secretaryDto.getPhoneNumber());
            }

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
