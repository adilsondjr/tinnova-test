package br.com.adilsondjr.tinnova.veiculoservice.unit.controller;

import br.com.adilsondjr.tinnova.veiculoservice.controller.VeiculoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(VeiculoController.class)
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;
}
