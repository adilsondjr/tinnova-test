package br.com.adilsondjr.tinnova.veiculoservice.handler;

import br.com.adilsondjr.tinnova.veiculoservice.handler.exception.VeiculoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    public static final URI VEICULO_NOT_FOUND_URI = URI.create("https://veiculo.com/errors/not-found");

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(VeiculoNotFoundException.class)
    public ProblemDetail veicuoNotFound(VeiculoNotFoundException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        problemDetail.setTitle("Veiculo not found.");
        problemDetail.setType(VEICULO_NOT_FOUND_URI);
        return problemDetail;
    }
}
