package it.develhope.StudioMedico.dto;

import it.develhope.StudioMedico.entities.StatusRecord;

public class SecretaryDto {

    private String name;
    private String surname;
    private String fiscalCode;
    private String email;
    private String phoneNumber;
    private String address;
    private StatusRecord status;
    public SecretaryDto() {
    }

    public SecretaryDto(StatusRecord status, String name, String surname, String fiscalCode, String email, String phoneNumber, String address) {
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public String getFiscalCode() {
        return fiscalCode;
    }


    public String getEmail() {
        return email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getAddress() {
        return address;
    }

    public StatusRecord getStatus() {
        return status;
    }
}
