package br.com.adilsondjr.tinnova.veiculoservice.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public record VeiculoResponse(
        @NotBlank
        String veiculo,
        @NotBlank
        String marca,
        Integer ano,
        @NotBlank
        String descricao,
        Boolean vendido,
        @CreatedDate
        LocalDateTime created,
        @LastModifiedDate
        LocalDateTime updated
) {
}
