package it.develhope.StudioMedico.controllers;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.develhope.StudioMedico.repositories.SecretaryRepository;
import it.develhope.StudioMedico.entities.Secretary;
import it.develhope.StudioMedico.exceptions.SecretaryNotFoundException;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    
    private final SecretaryRepository repository;

    public SecretaryController(SecretaryRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    List<Secretary> all(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Secretary one(@PathVariable Long id) throws NameNotFoundException{
        return repository.findById(id).orElseThrow(() -> new SecretaryNotFoundException(id));
    }

    @PostMapping
    Secretary newSecretary(@RequestBody Secretary secretary){
        return repository.save(secretary);
    }

    @PutMapping("/{id}")
    Secretary replaceSecretary (@RequestBody Secretary newSecretary, @PathVariable Long id){
        return repository.findById(id)
            .map( secretary -> {
                secretary.setName(newSecretary.getName());
                secretary.setSurname(newSecretary.getSurname());
                secretary.setFiscalCode(newSecretary.getFiscalCode());
                secretary.setEmail(newSecretary.getEmail());
                secretary.setPhoneNumber(newSecretary.getPhoneNumber());
                secretary.setAddress(newSecretary.getPhoneNumber());
                    return repository.save(secretary);
                })
            .orElseGet(() -> {
                newSecretary.setSecretaryId(id);
                return repository.save(newSecretary);
            });
    }

    @DeleteMapping("/{id}")
    void deleteSecretary (@PathVariable Long id) {
        repository.deleteById(id);
    }

}
