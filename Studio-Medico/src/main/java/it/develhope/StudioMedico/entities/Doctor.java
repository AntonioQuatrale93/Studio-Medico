package it.develhope.StudioMedico.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * This doctor class has some useful information to describe at best a single doctor,
 * also it has:
 * - prenotationList that is a list with all the scheduled visit of a doctor (foreign key for the Database)
 * - secretary that is the coworker for that doctor (the secretary id is the foreign key for the Database)
 * */
@Entity
@Table(name = "Doctors")

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id")
    private long doctorId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "fiscal_code")
    private String fiscalCode;
    @Column(unique = true, nullable = false, name = "email")
    private String email;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "doctor_phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;


    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Prenotation> prenotationList;

    @ManyToOne
    @JoinColumn(name = "secretary_id")
    private Secretary secretary;

    /**
     * A simple constructor with no argument
     * */
    public Doctor() {
    }

    /**
     * A simple constructor with all argument
     * */
    public Doctor(long doctorId, String name, String surname, String fiscalCode, String email, String specialization, String phoneNumber, String address, Set<Prenotation> prenotationList, Secretary secretary) {
        this.doctorId = doctorId;
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.email = email;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.prenotationList = prenotationList;
        this.secretary = secretary;
    }

    /**
     * This is the getter for the doctor ID
     * @return the Id of the doctor
     * */
    public long getDoctorId() {
        return doctorId;
    }

    /**
     * This is the setter for the doctor ID
     * */
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * This is the getter for the name of the doctor
     * @return the name of the doctor
     * */
    public String getName() {
        return name;
    }

    /**
     * This is the setter for the name of the doctor
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is the getter for the surname of the doctor
     * @return the surname of the doctor
     * */
    public String getSurname() {
        return surname;
    }

    /**
     * This is the setter for the surname of the doctor
     * */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * This is the getter for the fiscal code of the doctor
     * @return the fiscal code of the doctor
     * */
    public String getFiscalCode() {
        return fiscalCode;
    }

    /**
     * This is the setter for the fiscal code of the doctor
     * */
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    /**
     * This is the getter for the email of the doctor
     * @return the email of the doctor
     * */
    public String getEmail() {
        return email;
    }

    /**
     * This is the setter for the email of the doctor
     * */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This is the getter for the specialization of the doctor
     * @return the specialization of the doctor
     * */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * This is the setter for the specialization of the doctor
     * */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * This is the getter for the phone number of the doctor
     * @return the phone number of the doctor
     * */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This is the setter for the phone number of the doctor
     * */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This is the getter for the address of the doctor
     * @return the address of the doctor
     * */
    public String getAddress() {
        return address;
    }

    /**
     * This is the setter for the address of the doctor
     * */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This is the getter for the prenotations of the doctor
     * @return a list of all the prenotations of the doctor
     * */
    public Set<Prenotation> getPrenotationList() {
        return prenotationList;
    }

    /**
     * This is the setter for the prenotations of the doctor
     * */
    public void setPrenotationList(Set<Prenotation> prenotationList) {
        this.prenotationList = prenotationList;
    }

    /**
     * This is the getter for the secretary of the doctor
     * @return the specialization of the doctor
     * */
    public Secretary getSecretary() {
        return secretary;
    }

    /**
     * This is the setter for the secretary of the doctor
     * */
    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }
}





