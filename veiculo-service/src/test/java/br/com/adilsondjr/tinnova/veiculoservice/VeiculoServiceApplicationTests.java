package br.com.adilsondjr.tinnova.veiculoservice;

import br.com.adilsondjr.tinnova.veiculoservice.controller.VeiculoController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VeiculoServiceApplicationTests {

	@Autowired
	private VeiculoController veiculoController;

	@Test
	void contextLoads() {
		Assertions.assertThat(veiculoController).isNotNull();
	}

}
