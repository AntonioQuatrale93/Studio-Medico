package it.develhope.StudioMedico.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
public class Prenotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prenotation_id")
    private long prenotationId;
    @Column(name = "prenotation_date")
    private Date date;
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    private Prenotation() {
    }


    private Prenotation( long prenotationId, Date date, Patient patient, Doctor doctor) {
        this.prenotationId = prenotationId;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;

    }

    public long getPrenotationId() {
        return prenotationId;
    }

    public void setPrenotationId(long prenotationId) {
        this.prenotationId = prenotationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
