package it.develhope.StudioMedico.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Dottori")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id")
    private long doctorId;
    @Column(name = "doctor_name")
    private String name;
    @Column(name = "doctor_surname")
    private String surname;
    @Column(name = "fiscal_code")
    private String fiscalCode;
    @Column(unique = true, nullable = false)
    private String email;
    private String specialization;
    @Column(name = "doctor_phone_number")
    private String phoneNumber;
    private String address;



    @OneToMany
    @JoinColumn(name = "prenotation_id")
    List<Prenotation> prenotationList;
    @OneToOne
    @JoinColumn(name = "secretary_id")
    Secretary secretary;
}
