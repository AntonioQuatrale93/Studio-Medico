package it.develhope.StudioMedico.dto;

public class PatientDto {


    private String phone_Number;
    private String address;

    private PatientDto() {

    }

    private PatientDto(String phone_Number, String address) {
        this.address = address;
        this.phone_Number = phone_Number;
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
}

