package it.develhope.StudioMedico.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "secretary_id")
    private long secretaryId;
    @Column(name = "secretary_name")
    private String name;
    @Column(name = "secretary_surname")
    private String surname;
    @Column(name = "fiscal_code")
    private String fiscalCode;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "secretary_phone_number")
    private String phoneNumber;
    private String address;

    @OneToMany
    @JoinColumn(name = "doctor_id")
    List<Doctor> doctorList;
}
