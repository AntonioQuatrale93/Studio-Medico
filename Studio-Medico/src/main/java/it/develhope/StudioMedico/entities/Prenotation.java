package it.develhope.StudioMedico.entities;

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
    @Column(name = "status")
    private PrenotationStatus prenotationStatus;
    @Column(name = "translated_status")
    private String statusRecord;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;



    private Prenotation() {
    }


    private Prenotation( long prenotationId, Date date, Patient patient, Doctor doctor, PrenotationStatus prenotationStatus) {
        this.prenotationId = prenotationId;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
        this.prenotationStatus = PrenotationStatus.BOOKED;
        this.statusRecord = String.valueOf(prenotationStatus);

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

    public PrenotationStatus getPrenotationStatus() {
        return prenotationStatus;
    }

    public void setPrenotationStatus(PrenotationStatus prenotationStatus) {
        this.prenotationStatus = prenotationStatus;
    }

    public String getStatusRecord() {
        return statusRecord;
    }

    public void setStatusRecord(String statusRecord) {
        this.statusRecord = statusRecord;
    }
}
