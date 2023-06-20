package br.com.adilsondjr.tinnova.veiculoservice.handler.exception;

public class VeiculoNotFoundException extends RuntimeException{
    public VeiculoNotFoundException() {
        super("Veiculo not found.");
    }
}
