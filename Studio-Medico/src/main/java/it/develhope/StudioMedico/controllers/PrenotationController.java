package it.develhope.StudioMedico.controllers;

import it.develhope.StudioMedico.dto.PrenotationDto;
import it.develhope.StudioMedico.entities.Prenotation;
import it.develhope.StudioMedico.serviceImpl.PrenotationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * This class use all the Api defined in PrenotationServiceImpl
 */
@RestController
@RequestMapping("/prenotation")
public class PrenotationController {

    @Autowired
    private PrenotationServiceImpl prenotationServiceImpl;


    @PostMapping
    public ResponseEntity<Prenotation> createPrenotation(@RequestBody Prenotation prenotation, @RequestParam long doctorId, @RequestParam long patientId) {
        return prenotationServiceImpl.createPrenotation(prenotation, doctorId, patientId);
    }


    @GetMapping
    public List<Prenotation> getAllPrenotation() {
        return prenotationServiceImpl.getAllPrenotation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Prenotation>> getPrenotationById(@PathVariable long id) {
        return prenotationServiceImpl.getPrenotationById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Prenotation> updatePrenotation(@PathVariable long id, @RequestBody PrenotationDto prenotationDto) {
        return prenotationServiceImpl.updatePrenotation(id, prenotationDto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity deletePrenotationById(@PathVariable long id) {
        return prenotationServiceImpl.deletePrenotationById(id);
    }

    @PatchMapping("/delete")
    public void deleteAllPrenotation() {
        prenotationServiceImpl.deleteAllPrenotation();
    }
}
