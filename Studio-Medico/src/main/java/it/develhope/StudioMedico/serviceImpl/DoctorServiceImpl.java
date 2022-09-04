package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
import it.develhope.StudioMedico.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorsRepository doctorsRepository;


    @Override
    public ResponseEntity<Doctor> createDoctor(Doctor doctor) {
        doctorsRepository.save(doctor);
        return ResponseEntity.status(201).body(doctor);
    }

    @Override
    public ResponseEntity<Optional<Doctor>> getById(Long id) {
        if (doctorsRepository.existsById(id)){
            return ResponseEntity.ok().body(doctorsRepository.findById(id));
        }else {
            return new ResponseEntity("not found id doctor : ", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorsRepository.findAll();
    }

    @Override
    public ResponseEntity<Doctor> updateDoctor(Long id, DoctorDto doctorDto) {
        if (doctorsRepository.existsById(id)) {
            Doctor doctor = doctorsRepository.findById(id).get();
            doctor.setAddress(doctorDto.getAddress());
            doctor.setPhoneNumber(doctorDto.getPhoneNumber());
            Doctor newDoctor = doctorsRepository.saveAndFlush(doctor);
            return ResponseEntity.ok(newDoctor);
        }else {
            return new ResponseEntity("doctor not found : ", HttpStatus.NOT_FOUND);
         }
        }


    @Override
    public ResponseEntity deleteById(Long id) {
        if (doctorsRepository.existsById(id)) {
            doctorsRepository.deleteById(id);
            return ResponseEntity.status(201).body("deleteById success");
        } else {
            return new ResponseEntity(" not found: " + id,HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity deleteAll() {
        doctorsRepository.deleteAll();
        return new ResponseEntity("secretaryDelete :",HttpStatus.NO_CONTENT);
    }
}