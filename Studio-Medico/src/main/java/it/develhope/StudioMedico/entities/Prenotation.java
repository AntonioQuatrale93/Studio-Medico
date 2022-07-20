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
    private long prenotationId;
    private Date date;
    @OneToOne
    Patient patient;
    @OneToOne
    Doctor doctor;
}
