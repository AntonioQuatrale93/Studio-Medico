package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
import it.develhope.StudioMedico.repositories.SecretaryRepository;
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

    @Autowired
    private SecretaryRepository secretaryRepository;


    @Override
    public ResponseEntity<Doctor> createDoctor(Doctor doctor) {
        doctorsRepository.save(doctor);
        return ResponseEntity.status(201).body(doctor);
    }

    @Override
    public ResponseEntity<Optional<Doctor>> getById(Long id) {
        if (doctorsRepository.existsById(id)) {
            Optional<Doctor> doctor = doctorsRepository.findById(id);
            return ResponseEntity.ok().body(doctor);
        }
        return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorsRepository.findAll();
    }

    @Override
    public List<Prenotation> getAllPrenotation(Long id) throws Exception {
        if (doctorsRepository.existsById(id)) {
            return doctorsRepository.findById(id).get().getPrenotationList();
        } else throw new Exception("this doctor does not exist");
    }

    @Override
    public List<Patient> getPatientList(Long doctorId) throws Exception {
        if (doctorsRepository.existsById(doctorId)) {
            return doctorsRepository.findById(doctorId).get().getPatientSet();
        } else throw new Exception("this doctor does not exist");
    }

    @Override
    public ResponseEntity<Doctor> updateDoctor(Long id, DoctorDto doctorDto) {
        if (doctorsRepository.existsById(id)) {
            Doctor doctor = doctorsRepository.findById(id).get();
            if (doctorDto.getName() != null) {
                doctor.setName(doctor.getName());
            }
            if (doctorDto.getSurname() != null) {
                doctor.setSurname(doctor.getSurname());
            }
            if (doctorDto.getFiscalCode() != null) {
                doctor.setFiscalCode(doctor.getFiscalCode());
            }
            if (doctorDto.getEmail() != null) {
                doctor.setEmail(doctor.getEmail());
            }
            if (doctorDto.getSpecialization() != null) {
                doctor.setSpecialization(doctor.getSpecialization());
            }
            if (doctorDto.getAddress() != null) {
                doctor.setAddress(doctorDto.getAddress());
            }
            if (doctorDto.getPhoneNumber() != null) {
                doctor.setPhoneNumber(doctorDto.getPhoneNumber());
            }

            Doctor newDoctor = doctorsRepository.saveAndFlush(doctor);
            return ResponseEntity.ok(newDoctor);
        } else {
            return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Doctor> assignSecretary(Long doctorId, Long secretaryId) {
        if (secretaryRepository.existsById(secretaryId)) {
            Doctor doctor = doctorsRepository.findById(doctorId).get();
            doctor.setSecretary(secretaryRepository.findById(secretaryId).get());
            Doctor updatedDoctor = doctorsRepository.saveAndFlush(doctor);
            return ResponseEntity.ok(updatedDoctor);
        }
        return new ResponseEntity("no doctor exist with id " + doctorId, HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity deleteById(Long id) {
        if (doctorsRepository.existsById(id)) {
            doctorsRepository.deleteById(id);
            return new ResponseEntity( HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity deleteAll() {
        doctorsRepository.deleteAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}