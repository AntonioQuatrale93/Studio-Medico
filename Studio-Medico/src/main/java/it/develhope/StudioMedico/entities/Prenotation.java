package it.develhope.StudioMedico.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "prenotations")

public class Prenotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prenotation_id")
    private long prenotationId;
    @Column(name = "prenotation_date", nullable = false)
    private LocalDate date;
    @Column(name = "time", nullable = false)
    private LocalTime time;
    @Column(name = "status")
    private StatusRecord status;
    /**
     * questo campo è una stringa che traduce il valore numerico di "status" in modo che sia leggibile su SQL
     * Ex: "status: 0 translated_status: BOOKED"
     */
    @Column(name = "translated_status")
    private String translatedStatus = String.valueOf(this.getStatus());

    @ManyToOne

    @JoinColumn(name = "ext_patient_id", nullable = false)
    private Patient patient;

    @ManyToOne

    @JoinColumn(name = "ext_doctor_id", nullable = false)
    private Doctor doctor;


    private Prenotation() {
    }

    public Prenotation(long prenotationId, LocalDate date, StatusRecord status, String translatedStatus, Patient patient, Doctor doctor, LocalTime time) {
        this.prenotationId = prenotationId;
        this.date = date;
        this.time = time;
        this.status = status;
        this.translatedStatus = String.valueOf(this.getStatus());;
        this.patient = patient;
        this.doctor = doctor;
    }

    public long getPrenotationId() {
        return prenotationId;
    }

    public void setPrenotationId(long prenotationId) {
        this.prenotationId = prenotationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public StatusRecord getStatus() {
        return status;
    }

    public void setStatus(StatusRecord status) {
        this.status = status;
    }

    public String getTranslatedStatus() {
        return translatedStatus;
    }

    public void setTranslatedStatus(String translatedStatus) {
        this.translatedStatus = translatedStatus;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
