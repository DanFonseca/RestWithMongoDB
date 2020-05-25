package br.com.restwithmongodb.demo.Servces.Excpetions;

import br.com.restwithmongodb.demo.Models.Exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e , HttpServletRequest sr){
        StandardError err =
                new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), "ID not found", sr.getRequestURI());

        return ResponseEntity.status(err.getStatus()).body(err);
    }
}
