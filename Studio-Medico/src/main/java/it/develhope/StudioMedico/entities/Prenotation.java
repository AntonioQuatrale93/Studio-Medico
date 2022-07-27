package it.develhope.StudioMedico.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
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
    Patient patient;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;
}
