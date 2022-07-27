package it.develhope.StudioMedico.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pazienti")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private long patientId;
    @Column(name = "patient_name")
    private String name;
    @Column(name = "patient_surname")
    private String surname;
    @Column(name = "fiscal_code")
    private String fiscalCode;
    @Column(name = "patient_age")
    private int age;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "patient_phone_number")
    private String phoneNumber;
    private String address;


    @OneToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;
    @OneToMany
    @JoinColumn(name = "prenotation_id")
    List<Prenotation> bookedVisits;



}
