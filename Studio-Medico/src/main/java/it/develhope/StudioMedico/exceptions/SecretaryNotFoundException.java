package it.develhope.StudioMedico.exceptions;

public class SecretaryNotFoundException extends RuntimeException {
    public SecretaryNotFoundException(Long id){
        super("Could not find Secretary: " + id);
    }
}
