package it.develhope.StudioMedico.dto;

import it.develhope.StudioMedico.entities.PrenotationStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrenotationDto {

    private LocalDate date;
    private LocalTime time;
    private Long doctorId;
    private Long patientId;
    private PrenotationStatus prenotationStatus;


    public PrenotationDto() {
    }

    public PrenotationDto(LocalDate date, Long doctorId, Long patientId, PrenotationStatus prenotationStatus, LocalTime time) {
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.prenotationStatus = prenotationStatus;
    }

    public LocalDate getDate() {
        return date;
    }


    public Long getDoctorId() {
        return doctorId;
    }


    public Long getPatientId() {
        return patientId;
    }


    public PrenotationStatus getPrenotationStatus() {
        return prenotationStatus;
    }

    public LocalTime getTime() {
        return time;
    }
}
