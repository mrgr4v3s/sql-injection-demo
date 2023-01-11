package br.com.db1.anymarket.sqlinjectiondemo.controller;

import jakarta.persistence.NoResultException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity noUserFound(Exception exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> internalServerError(Exception exception) {
        return ResponseEntity.badRequest().body("Algo deu errado. Ajuste sua requisição e tente novamente");
    }
}
