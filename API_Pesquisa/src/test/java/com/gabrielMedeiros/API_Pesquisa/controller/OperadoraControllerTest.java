package com.gabrielMedeiros.API_Pesquisa.controller;

import com.gabrielMedeiros.API_Pesquisa.model.Operadora;
import com.gabrielMedeiros.API_Pesquisa.service.OperadoraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(OperadoraControllerTest.class)
@ActiveProfiles("test")
class OperadoraControllerTest {

    //Testes de unidade com mock
    @Autowired
    private MockMvc mvc;

    @Mock
    public OperadoraService service;

    @InjectMocks
    private OperadoraController controller;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Deve retoranr OK com lista de operadoras")
    void retornar200ComListaDeOperadoras() throws Exception {
        var operadoraMock = new Operadora(
                null, "12.345.678/0001-90", "Razão Social Teste", "Fantasia Teste",
                "Autogestão", "Rua Exemplo", "123", "", "Bairro Exemplo",
                "Campina Grande", "PB", "58000-000", "83", "3333-0000", "3333-0001",
                "email@teste.com", "Fulano", "Diretor", 1, LocalDate.of(2023, 1, 1)
        );

        when(service.buscarComFiltros(null, null, null)).thenReturn(List.of(operadoraMock));

        mvc.perform(get("/operadoras/busca"))
                .andExpect(status().isOk()); // verifica se retornou 200
    }


    @Test
    @DisplayName("Deve retornar 404 Not Found quando endpoint não existe")
    void retornar400QuandoUfInvalido() throws Exception {
        mvc.perform(get("/operadoras/buscaa"))
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("Deve retornar 500 Internal Server Error em caso de falha no servidor")
    void retornar500QuandoServiceFalha() throws Exception {
        when(service.buscarComFiltros(any(), any(), any()))
                .thenThrow(new RuntimeException("Erro interno simulado"));

        mvc.perform(get("/operadoras/busca"))
                .andExpect(status().isInternalServerError());
    }
    //O stack trace irá confirmar o que se deseja simular: falha interna no servidor(HTTP 500) causada por uma exceção
}