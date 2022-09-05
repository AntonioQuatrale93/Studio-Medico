package it.develhope.StudioMedico.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "secretary")

public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "secretary_id")
    private long secretaryId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "fiscal_code")
    private String fiscalCode;
    @Column(unique = true, nullable = false, name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "secretary", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Doctor> doctorList;

    private Secretary() {
    }

    public Secretary(Long secretaryId, String name, String surname, String fiscalCode, String email, String phoneNumber, String address, List<Doctor> doctorList) {
        this.secretaryId = secretaryId;
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
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
