package it.develhope.StudioMedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patients")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private long patientId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "fiscal_code")
    private String fiscalCode;
    @Column(name = "age")
    private Integer age;
    @Column(unique = true, nullable = false, name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;


    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Prenotation> prenotationList;


    public Patient() {
    }


    public Patient(Long patientId, String name, String surname, String fiscalCode, Integer age, String email, String phoneNumber, String address, Doctor doctor, List<Prenotation> prenotationList) {
        this.patientId = patientId;
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.doctor = doctor;
        this.prenotationList = prenotationList;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Prenotation> getPrenotationList() {
        return prenotationList;
    }

    public void setPrenotationList(List<Prenotation> prenotationList) {
        this.prenotationList = prenotationList;
    }
}


