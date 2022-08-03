package it.develhope.StudioMedico.entities;


import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    private Set<Prenotation> prenotationList;
    @ManyToOne
    @JoinColumn(name = "secretary_id" )
    private Secretary secretary;

    public Doctor() {}

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

    public long getDoctorId() {
        return doctorId;
    }


    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public Set<Prenotation> getPrenotationList() {
        return (Set<Prenotation>) prenotationList;
    }

    public void setPrenotationList(List<Prenotation> prenotationList) {
        this.prenotationList = (Set<Prenotation>) prenotationList;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }
}

