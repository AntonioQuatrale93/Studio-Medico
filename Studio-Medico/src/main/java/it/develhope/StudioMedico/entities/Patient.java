package it.develhope.StudioMedico.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientId;
    private String name;
    private String surname;
    private String fiscalCode;
    private int age;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne
    Doctor doctor;
    @OneToMany
    List<Prenotation> bookedVisits;
}
