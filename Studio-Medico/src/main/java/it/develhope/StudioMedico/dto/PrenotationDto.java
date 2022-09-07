package it.develhope.StudioMedico.dto;

import it.develhope.StudioMedico.entities.StatusRecord;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrenotationDto {

    private LocalDate date;
    private LocalTime time;
    private Long doctorId;
    private Long patientId;
    private StatusRecord status;


    public PrenotationDto() {
    }

    public PrenotationDto(LocalDate date, Long doctorId, Long patientId, StatusRecord status, LocalTime time) {
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.status = status;
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


    public StatusRecord getPrenotationStatus() {
        return status;
    }

    public LocalTime getTime() {
        return time;
    }
}
