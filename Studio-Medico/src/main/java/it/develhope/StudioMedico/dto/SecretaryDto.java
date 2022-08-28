package it.develhope.StudioMedico.dto;

public class SecretaryDto {

    private String name;

    private String surname;

    private String email;

    private int age;

    private String fiscalCode;

    private String phoneNumber;
    private String address;

    public SecretaryDto() {
    }

    public SecretaryDto(String name,String surname,String email,int age,String fiscalCode,String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name=name;
        this.surname=surname;
        this.fiscalCode=fiscalCode;
        this.email=email;
        this.age=age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
}
