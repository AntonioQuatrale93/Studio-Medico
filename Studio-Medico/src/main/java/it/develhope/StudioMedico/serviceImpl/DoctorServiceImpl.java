package it.develhope.StudioMedico.serviceImpl;

import it.develhope.StudioMedico.dto.DoctorDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.entities.Patient;
import it.develhope.StudioMedico.entities.Prenotation;
import it.develhope.StudioMedico.entities.StatusRecord;
import it.develhope.StudioMedico.repositories.DoctorsRepository;
import it.develhope.StudioMedico.repositories.SecretaryRepository;
import it.develhope.StudioMedico.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    @Autowired
    private SecretaryRepository secretaryRepository;

    /**
     * Create entity doctor
     *
     * @param doctor
     * @return doctor
     */
    @Override
    public ResponseEntity<Doctor> createDoctor(Doctor doctor) {
        doctor.setStatus(StatusRecord.ACTIVE);
        doctorsRepository.save(doctor);
        return ResponseEntity.status(201).body(doctor);
    }

    /**
     * Return the doctor by id
     *
     * @param id
     * @return doctor
     */
    @Override
    public ResponseEntity<Optional<Doctor>> getById(Long id) {
        if (doctorsRepository.existsById(id)) {
            Optional<Doctor> doctor = doctorsRepository.findById(id);
            return ResponseEntity.ok().body(doctor);
        }
        return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
    }

    /**
     * Return all the doctors
     *
     * @return doctors
     */
    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorsList = new ArrayList<>();
        doctorsRepository.findAll().forEach(doctor -> {
            if (doctor.getStatus() == StatusRecord.ACTIVE) {
                doctorsList.add(doctor);
            }
        });
        return doctorsList;
    }

    @Override
    public List<Doctor> getAllDeletedDoctors() {
        List<Doctor> doctorsList = new ArrayList<>();
        doctorsRepository.findAll().forEach(doctor -> {
            if (doctor.getStatus() == StatusRecord.DELETED) {
                doctorsList.add(doctor);
            }
        });
        return doctorsList;
    }

    /**
     * Ritorna tutte le prenotazioni del doctor tramite id
     *
     * @param id
     * @return prenotationListById;
     */
    @Override
    public List<Prenotation> getAllDoctorPrenotation(Long id) throws Exception {
        if (doctorsRepository.existsById(id)) {
            List<Prenotation> doctorActivePrenotation = new ArrayList<>();
            doctorsRepository.findById(id).get().getPrenotationList().forEach(prenotation -> {
                if (prenotation.getStatus() == StatusRecord.ACTIVE) {
                    doctorActivePrenotation.add(prenotation);
                }
            });
            return doctorActivePrenotation;
        } else throw new Exception("this doctor does not exist");
    }

    /**
     * Ritorna i patients del doctor tramite id
     *
     * @param doctorId
     * @return patientListById
     */
    @Override
    public List<Patient> getDoctorPatientList(Long doctorId) throws Exception {
        if (doctorsRepository.existsById(doctorId)) {
            List<Patient> activePatientList = new ArrayList<>();
            doctorsRepository.findById(doctorId).get().getPatientList().forEach(patient -> {
                if (patient.getStatus() == StatusRecord.ACTIVE) {
                    activePatientList.add(patient);
                }
            });
            return activePatientList;
        } else throw new Exception("this doctor does not exist");
    }

    /**
     * Modifica un entità doctor
     *
     * @param id
     * @param doctorDto
     * @return newDoctor
     */
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

    /**
     * Assegna un entità Secretary ad un entità doctor
     *
     * @param doctorId
     * @param secretaryId
     * @return updatedDoctor
     */
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

    /**
     * Elimina un entità doctor tramite id
     *
     * @param id
     */
    @Override
    public ResponseEntity deleteById(Long id) {
        if (doctorsRepository.existsById(id)) {
            Doctor doctor = doctorsRepository.findById(id).get();
            doctor.setStatus(StatusRecord.DELETED);
            doctorsRepository.saveAndFlush(doctor);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Elimina tutte le entità doctor
     */
    @Override
    public ResponseEntity deleteAll() {
        doctorsRepository.findAll().forEach(doctor -> {
            doctor.setStatus(StatusRecord.DELETED);
            doctorsRepository.saveAndFlush(doctor);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}