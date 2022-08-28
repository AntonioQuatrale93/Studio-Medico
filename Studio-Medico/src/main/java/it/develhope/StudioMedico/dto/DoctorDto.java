package it.develhope.StudioMedico.dto;

/**
 * Questa classe contiene solo gli attributi modificabili del dottore, ovvero indirizzo e numero di telefono
 */
public class DoctorDto {

    private String name;

    private String surname;

    private String email;

    private String fiscalCode;

    private String specialization;
    private String phoneNumber;
    private String address;

    public DoctorDto() {
    }

    public DoctorDto(String name,String surname,String email,String fiscalCode,String specialization,String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.fiscalCode=fiscalCode;
        this.specialization=specialization;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
