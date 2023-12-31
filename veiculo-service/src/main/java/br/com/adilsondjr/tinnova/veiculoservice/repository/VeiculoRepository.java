package br.com.adilsondjr.tinnova.veiculoservice.repository;

import br.com.adilsondjr.tinnova.veiculoservice.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
}
