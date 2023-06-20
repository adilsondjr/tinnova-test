package br.com.adilsondjr.tinnova.veiculoservice.util;

import br.com.adilsondjr.tinnova.veiculoservice.domain.Veiculo;
import br.com.adilsondjr.tinnova.veiculoservice.dto.VeiculoRequest;
import org.springframework.util.StringUtils;

public class VeiculoMerge {

    public static Veiculo merge(Veiculo veiculo, VeiculoRequest veiculoRequest) {
        veiculo.setVeiculo(StringUtils.hasText(veiculoRequest.veiculo()) ? veiculoRequest.veiculo() : veiculo.getVeiculo());
        veiculo.setMarca(StringUtils.hasText(veiculoRequest.marca()) ? veiculoRequest.marca() : veiculo.getMarca());
        veiculo.setAno(veiculoRequest.ano() != null ? veiculoRequest.ano() : veiculo.getAno());
        veiculo.setDescricao(StringUtils.hasText(veiculoRequest.descricao()) ? veiculoRequest.descricao() : veiculo.getDescricao());
        veiculo.setVendido(veiculoRequest.vendido() != null ? veiculoRequest.vendido() : veiculo.getVendido());
        return veiculo;
    }

}
