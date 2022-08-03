package it.develhope.StudioMedico.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "prenotations")

public class Prenotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prenotation_id")
    private long prenotationId;
    @Column(name = "prenotation_date")
    private Date date;
    @Column(name = "status")
    private PrenotationStatus prenotationStatus;
    //questo campo è una stringa che traduce il valore numerico di "status" in modo che sia leggibile su SQL
    //Ex: "status: 0 translated_status: BOOKED"
    @Column(name = "translated_status")
    private String statusRecord = String.valueOf(this.getPrenotationStatus());

    @ManyToOne
    @JoinColumn(name = "ext_patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "ext_doctor_id", nullable = false)
    private Doctor doctor;



    private Prenotation() {
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
