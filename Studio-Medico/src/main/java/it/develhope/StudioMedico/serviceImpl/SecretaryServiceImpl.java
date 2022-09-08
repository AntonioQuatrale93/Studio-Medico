package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.SecretaryDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Secretary;
import it.develhope.StudioMedico.entities.StatusRecord;
import it.develhope.StudioMedico.repositories.SecretaryRepository;
import it.develhope.StudioMedico.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implement all the method defined by SecretaryService Interface
 */
@Service
public class SecretaryServiceImpl implements SecretaryService {


    @Autowired
    private SecretaryRepository secretaryRepository;

    /**
     * This API create and save a secretary in his repository
     *
     * @param secretary
     * @return secretary
     */
    @Override
    public ResponseEntity<Secretary> createSecretary(Secretary secretary) {
        secretary.setStatus(StatusRecord.ACTIVE);
        secretaryRepository.save(secretary);
        return ResponseEntity.status(201).body(secretary);
    }

    /**
     * This API find all the secretary in the repository
     *
     * @return secretaryList
     */
    @Override
    public List<Secretary> getSecretary() {
        List<Secretary> secretaryList = new ArrayList<>();
        secretaryRepository.findAll().forEach(secretary -> {
            if (secretary.getStatus() == StatusRecord.ACTIVE) {
                secretaryList.add(secretary);
            }
        });
        return secretaryList;
    }

    public List<Secretary> getDeletedSecretary() {
        List<Secretary> secretaryList = new ArrayList<>();
        secretaryRepository.findAll().forEach(secretary -> {
            if (secretary.getStatus() == StatusRecord.DELETED) {
                secretaryList.add(secretary);
            }
        });
        return secretaryList;
    }

    /**
     * This API return the list of doctor assigned to a secretary in his repository
     *
     * @param id
     * @return doctorList
     * @throws Exception
     */
    @Override
    public List<Doctor> getAllDoctor(Long id) throws Exception {
        if (secretaryRepository.existsById(id)) {
            List<Doctor> doctorList = secretaryRepository.findById(id).get().getDoctorList();
            return doctorList;
        }
        throw new Exception("secretary not found");
    }

    /**
     * This API update a secretary by his DTO
     *
     * @param id
     * @param secretaryDto
     * @return updatedSecretary
     */
    public ResponseEntity<Secretary> updateSecretary(Long id, SecretaryDto secretaryDto) {
        if (secretaryRepository.existsById(id)) {
            Secretary secretary = secretaryRepository.findById(id).get();
            if (secretaryDto.getName() != null) {
                secretary.setName(secretaryDto.getName());
            }
            if (secretaryDto.getSurname() != null) {
                secretary.setSurname(secretaryDto.getSurname());
            }
            if (secretaryDto.getFiscalCode() != null) {
                secretary.setFiscalCode(secretaryDto.getFiscalCode());
            }
            if (secretaryDto.getEmail() != null) {
                secretary.setEmail(secretaryDto.getEmail());
            }
            if (secretaryDto.getAddress() != null) {
                secretary.setAddress(secretaryDto.getAddress());
            }
            if (secretaryDto.getPhoneNumber() != null) {
                secretary.setPhoneNumber(secretaryDto.getPhoneNumber());
            }

            Secretary updatedSecretary = secretaryRepository.saveAndFlush(secretary);
            return ResponseEntity.ok(updatedSecretary);
        }
        return new ResponseEntity("Secretary with id " + id + " not found", HttpStatus.NOT_FOUND);
    }

    /**
     * This API delete all the secretaries
     *
     * @return ResponseEntity
     */
    @Override
    public ResponseEntity deleteSecretary() {
        secretaryRepository.findAll().forEach(secretary -> {
            secretary.setStatus(StatusRecord.DELETED);
            secretaryRepository.saveAndFlush(secretary);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
