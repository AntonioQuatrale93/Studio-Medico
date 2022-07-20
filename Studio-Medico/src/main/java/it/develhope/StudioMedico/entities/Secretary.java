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
    private long secretaryId;
    private String name;
    private String surname;
    private String fiscalCode;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany
    List<Doctor> doctorList;
}
