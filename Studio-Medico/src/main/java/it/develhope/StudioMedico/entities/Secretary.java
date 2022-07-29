package it.develhope.StudioMedico.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "secretary_id")
    private Long secretaryId;
    @Column(name = "secretary_name")
    private String name;
    @Column(name = "secretary_surname")
    private String surname;
    @Column(name = "fiscal_code")
    private String fiscalCode;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "secretary_phone_number")
    private String phoneNumber;
    private String address;

    @OneToMany
    @JoinColumn(name = "doctor_id")
    List<Doctor> doctorList;

    private Secretary() {
    }


    private Secretary(Long secretaryId, String name, String surname, String fiscalCode, String email, String phoneNumber, String address, List doctorList) {
        this.secretaryId = secretaryId;
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.doctorList = doctorList;
    }

    public long getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(long secretaryId) {
        this.secretaryId = secretaryId;
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

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
