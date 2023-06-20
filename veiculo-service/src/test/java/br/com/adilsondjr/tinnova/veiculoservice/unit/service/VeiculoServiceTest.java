package br.com.adilsondjr.tinnova.veiculoservice.unit.service;

import br.com.adilsondjr.tinnova.veiculoservice.domain.Veiculo;
import br.com.adilsondjr.tinnova.veiculoservice.handler.exception.VeiculoNotFoundException;
import br.com.adilsondjr.tinnova.veiculoservice.repository.VeiculoRepository;
import br.com.adilsondjr.tinnova.veiculoservice.service.VeiculoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VeiculoServiceTest {
    @InjectMocks
    private VeiculoService veiculoService;
    @Mock
    private VeiculoRepository veiculoRepository;


    @Test
    void shouldSaveAVeiculo() {
        Veiculo veiculo = createVeiculo();

        when(veiculoRepository.save(any(Veiculo.class))).thenReturn(veiculo);

        Veiculo veiculoCreated = veiculoService.create(veiculo);

        verify(veiculoRepository, times(1)).save(any(Veiculo.class));

        veiculoAssertion(veiculo, veiculoCreated);
    }

    @Test
    void shouldReturnAListOfVeiculos() {
        Page<Veiculo> veiculos = new PageImpl<>(List.of(createVeiculo()));

        when(veiculoRepository.findAll(any(PageRequest.class))).thenReturn(veiculos);

        Page<Veiculo> veiculosPage = veiculoRepository.findAll(PageRequest.of(0, 10));

        verify(veiculoRepository, times(1)).findAll();

        assertEquals(1, veiculosPage.getSize());
        assertEquals(veiculos.toList().get(0).getVeiculo(), veiculosPage.toList().get(0).getVeiculo());
        assertEquals(veiculos.toList().get(0).getMarca(), veiculosPage.toList().get(0).getMarca());
        assertEquals(veiculos.toList().get(0).getAno(), veiculosPage.toList().get(0).getAno());
        assertEquals(veiculos.toList().get(0).getDescricao(), veiculosPage.toList().get(0).getDescricao());
        assertEquals(veiculos.toList().get(0).getVendido(), veiculosPage.toList().get(0).getVendido());
    }

    @Test
    void shouldFindAVeiculoById() {
        Veiculo veiculo = createVeiculo();

        when(veiculoRepository.findById(any())).thenReturn(Optional.of(veiculo));

        Veiculo veiculoResponse = veiculoService.getById(UUID.fromString("5fc0bed8-e634-4e5f-ad48-819b14d1afe0"));

        verify(veiculoRepository, times(1)).getById(any());

        veiculoAssertion(veiculo, veiculoResponse);
    }

    @Test
    void shouldThrowAVeiculoNotFound() {
        when(veiculoRepository.findById(any())).thenReturn(Optional.empty());

        final Exception exception =
                Assertions.assertThrows(
                        VeiculoNotFoundException.class,
                        () ->
                                veiculoService.getById(any()));

        final String expected = "Veiculo not found.";

        assertEquals(expected, exception.getMessage());
    }

    @Test
    void shouldExcludeAVeiculo() {
        final UUID id = UUID.fromString("5fc0bed8-e634-4e5f-ad48-819b14d1afe0");
        Veiculo veiculo = createVeiculo();

        when(veiculoRepository.findById(id)).thenReturn(Optional.of(veiculo));

        veiculoService.delete(id);

        assertDoesNotThrow(() -> veiculoService.delete(id));
    }

    @Test
    void shouldThrowVeiculoNotFoundWhenDeleteAVeiculo() {
        final UUID id = UUID.fromString("5fc0bed8-e634-4e5f-ad48-819b14d1afe0");

        when(veiculoRepository.findById(id)).thenThrow(new VeiculoNotFoundException());

        final Exception exception =
                Assertions.assertThrows(
                        VeiculoNotFoundException.class,
                        () ->
                                veiculoService.delete(id));

        final String expected = "Veiculo not found.";

        assertEquals(expected, exception.getMessage());
    }

    private Veiculo createVeiculo() {
        Veiculo veiculo = new Veiculo();

        veiculo.setVeiculo("Golf");
        veiculo.setId(UUID.fromString("5fc0bed8-e634-4e5f-ad48-819b14d1afe0"));
        veiculo.setDescricao("Golf 1.6 Sportline");
        veiculo.setMarca("Volkswagen");
        veiculo.setAno(2013);
        veiculo.setVendido(false);

        return veiculo;
    }

    private void veiculoAssertion(Veiculo expected, Veiculo atual) {
        assertEquals(expected.getId(), atual.getId());
        assertEquals(expected.getAno(), atual.getAno());
        assertEquals(expected.getDescricao(), atual.getDescricao());
        assertEquals(expected.getMarca(), atual.getMarca());
        assertEquals(expected.getVeiculo(), atual.getVeiculo());
        assertEquals(expected.getVendido(), atual.getVendido());
    }
}
