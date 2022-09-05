package it.develhope.StudioMedico.dto;

public class PatientDto {

    private String name;
    private String surname;
    private String fiscalCode;
    private Integer age;
    private String email;
    private String phoneNumber;
    private String address;

    public PatientDto() {
    }

    public PatientDto(String name, String surname, String fiscalCode, int age, String email, String phoneNumber, String address) {
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
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


    public Integer getAge() {
        return age;
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

}
