package it.develhope.StudioMedico.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pazienti")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "patient_name")
    private String name;
    @Column(name = "patient_surname")
    private String surname;
    @Column(name = "fiscal_code")
    private String fiscalCode;
    @Column(name = "patient_age")
    private int age;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "patient_phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;


    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @OneToMany(mappedBy = "patient")
    @JoinColumn(name = "prenotation_id")
    @Column(name = "booked_visits")
    private List<Prenotation> prenotationList;


    private Patient() {
    }


    private Patient(Long patientId, String name, String surname, String fiscalCode, Integer age, String email, String phoneNumber, String address, Doctor doctor, List prenotationList) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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


