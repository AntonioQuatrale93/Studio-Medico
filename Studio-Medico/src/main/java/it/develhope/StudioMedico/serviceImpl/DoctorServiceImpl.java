package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl {

    @Autowired
    private DoctorsRepository doctorsRepository;

    public Doctor create(Doctor doctor){
         return doctorsRepository.save(doctor);
    }

    public List<Doctor> getAllDoctor(){
        return doctorsRepository.findAll();
    }

    public Optional<Doctor> getById(Long id){
        return doctorsRepository.findById(id);
    }

    public Doctor updateDoctor(Long id, Doctor doctor){
        doctor.setDoctorId(id);
        Doctor newDoctor = doctorsRepository.saveAndFlush(doctor);
        return newDoctor;
    }

    public void deleteDoctor(){
        doctorsRepository.deleteAll();
    }

    public void deleteDoctorById(Long id){
        doctorsRepository.deleteById(id);
    }


}
