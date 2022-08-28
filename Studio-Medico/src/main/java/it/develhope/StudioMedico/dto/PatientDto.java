package it.develhope.StudioMedico.dto;

public class PatientDto {

    private String name;

    private String surname;

    private String fiscalCode;

    private String email;

    private  int age;
    private String phone_Number;
    private String address;


    private PatientDto() {

    }

    private PatientDto(String email,String name,String surname,int age,String fiscalCode,String phone_Number, String address) {
        this.phone_Number = phone_Number;
        this.address=address;
        this.age=age;
        this.email=email;
        this.fiscalCode=fiscalCode;
        this.surname=surname;
        this.name=name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

