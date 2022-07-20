package it.develhope.StudioMedico.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long doctorId;
    private String name;
    private String surname;
    private String fiscalCode;
    @Column(unique = true, nullable = false)
    private String email;
    private String specialization;



    @OneToMany
    List<Prenotation> prenotationList;
    @OneToOne
    Secretary secretary;
}
