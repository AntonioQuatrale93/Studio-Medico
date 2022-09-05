package it.develhope.StudioMedico.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> genericExceptionHandler(Exception e) {
        ErrorDetail errorModel = new ErrorDetail(500, "something wrong");
        logger.error("ERROR DETAIL: ", e);
        return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {
            ConstraintViolationException.class, DataIntegrityViolationException.class, SQLIntegrityConstraintViolationException.class
    })
    public ResponseEntity<?> notFoundHandler(Exception e) {
        ErrorDetail errorModel = new ErrorDetail(409, "this email is already used");
        logger.error("ERROR_DETAIL: ", e);
        return new ResponseEntity<>(errorModel, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<?> parameterExceptionHandler(Exception e) {
        ErrorDetail errorModel = new ErrorDetail(400, "missing parameter/s");
        logger.error("ERROR DETAIL: ", e);
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }
}
