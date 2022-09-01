package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
import it.develhope.StudioMedico.repositories.SecretaryRepository;
import it.develhope.StudioMedico.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    @Autowired
    private SecretaryRepository secretaryRepository;


    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorsRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> getById(Long id) {
        return doctorsRepository.findById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorsRepository.findAll();
    }

    @Override
    public Doctor updateDoctor(Long id, DoctorDto doctorDto) {
        if (doctorsRepository.existsById(id)) {
            Doctor doctor = doctorsRepository.findById(id).get();
            doctor.setAddress(doctorDto.getAddress());
            doctor.setPhoneNumber(doctorDto.getPhoneNumber());
            Doctor newDoctor = doctorsRepository.saveAndFlush(doctor);
            return newDoctor;
        }
        return null;
    }

    @Override
    public Doctor assignSecretary(Long doctorId, Long secretaryId) {
        if(secretaryRepository.existsById(secretaryId)){
            Doctor doctor = doctorsRepository.findById(doctorId).get();
            doctor.setSecretary(secretaryRepository.findById(secretaryId).get());
            Doctor updatedDoctor = doctorsRepository.saveAndFlush(doctor);
            return doctor;
        }
        return null;
    }


    @Override
    public ResponseEntity deleteById(Long id) {
        if (doctorsRepository.existsById(id)) {
            doctorsRepository.deleteById(id);
            return null;
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteAll() {
        doctorsRepository.deleteAll();
    }
}