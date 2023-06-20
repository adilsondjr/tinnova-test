package br.com.adilsondjr.tinnova.veiculoservice.dto;

import jakarta.validation.constraints.NotBlank;

public record VeiculoRequest(
        @NotBlank
        String veiculo,
        @NotBlank
        String marca,
        Integer ano,
        @NotBlank
        String descricao,
        Boolean vendido
) {
}
