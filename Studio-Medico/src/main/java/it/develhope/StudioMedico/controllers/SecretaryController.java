package it.develhope.StudioMedico.controllers;

import java.util.List;

import it.develhope.StudioMedico.dto.SecretaryDto;
import it.develhope.StudioMedico.entities.Doctor;
import it.develhope.StudioMedico.serviceImpl.SecretaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import it.develhope.StudioMedico.entities.Secretary;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {


    @Autowired
    private SecretaryServiceImpl secretaryServiceImpl;


    @GetMapping()
    List<Secretary> getSecretary() {
        return secretaryServiceImpl.getSecretary();
    }

    @GetMapping("/doctor/{id}")
    public List<Doctor> getAllDoctor(@PathVariable Long id) throws Exception {
        return secretaryServiceImpl.getAllDoctor(id);
    }


    @PostMapping
    Secretary createSecretary(@RequestBody Secretary secretary) {
        return secretaryServiceImpl.createSecretary(secretary);
    }

    @PatchMapping("/{id}")
    Secretary replaceSecretary(@RequestBody SecretaryDto secretaryDto, @PathVariable Long id) {
        return secretaryServiceImpl.updateSecretary(id, secretaryDto);

    }

    @DeleteMapping()
    void deleteSecretary() {
        secretaryServiceImpl.deleteSecretary();
    }

}
