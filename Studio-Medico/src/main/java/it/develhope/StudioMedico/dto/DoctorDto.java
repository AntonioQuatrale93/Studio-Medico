package it.develhope.StudioMedico.dto;

/**
 * Questa classe contiene solo gli attributi modificabili del dottore, ovvero indirizzo e numero di telefono
 */
public class DoctorDto {
    private String phoneNumber;
    private String address;

    public DoctorDto(){}

    public DoctorDto(String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
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
}
