package br.com.adilsondjr.tinnova.veiculoservice.service;

import br.com.adilsondjr.tinnova.veiculoservice.domain.Veiculo;
import br.com.adilsondjr.tinnova.veiculoservice.dto.VeiculoRequest;
import br.com.adilsondjr.tinnova.veiculoservice.handler.exception.VeiculoNotFoundException;
import br.com.adilsondjr.tinnova.veiculoservice.repository.VeiculoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo create(Veiculo veiculoRequest) {
        return veiculoRepository.save(veiculoRequest);
    }

    public Page<Veiculo> getAll(Pageable pageable) {
        return veiculoRepository.findAll(pageable);
    }

    public Veiculo getById(UUID id) {
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);

        if (veiculoOpt.isEmpty()) {
            throw new VeiculoNotFoundException();
        }

        Veiculo veiculo = veiculoOpt.get();

        return veiculo;
    }



    public void delete(UUID id) {
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);
        Veiculo veiculo = veiculoOpt.get();
        veiculoRepository.delete(veiculo);
    }
}
