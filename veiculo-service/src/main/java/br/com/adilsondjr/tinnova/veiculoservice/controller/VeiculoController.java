package br.com.adilsondjr.tinnova.veiculoservice.controller;

import br.com.adilsondjr.tinnova.veiculoservice.domain.Veiculo;
import br.com.adilsondjr.tinnova.veiculoservice.dto.VeiculoRequest;
import br.com.adilsondjr.tinnova.veiculoservice.service.VeiculoService;
import br.com.adilsondjr.tinnova.veiculoservice.util.VeiculoMerge;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private VeiculoService veiculoService;


    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Veiculo> create(@Valid @RequestBody Veiculo veiculoRequest) {
        Veiculo veiculoCreated = veiculoService.create(veiculoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCreated);
    }

    @GetMapping
    public ResponseEntity<Page<Veiculo>> getAll(@PageableDefault(size = 10) Pageable pageable) {
        Page<Veiculo> veiculoList = veiculoService.getAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoList);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Veiculo> getById(@PathVariable UUID id) {
        Veiculo veiculo = veiculoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(veiculo);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody @Valid VeiculoRequest veiculoRequest) {
        Veiculo veiculo = veiculoService.getById(id);
        BeanUtils.copyProperties(veiculoRequest, veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.create(veiculo));
    }

    @PatchMapping(value = "{id}")
    public ResponseEntity<Object> updateSomeProperties(@PathVariable UUID id, @RequestBody VeiculoRequest veiculoRequest) {
        Veiculo veiculo = veiculoService.getById(id);

        VeiculoMerge.merge(veiculo, veiculoRequest);

        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.create(veiculo));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        veiculoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
