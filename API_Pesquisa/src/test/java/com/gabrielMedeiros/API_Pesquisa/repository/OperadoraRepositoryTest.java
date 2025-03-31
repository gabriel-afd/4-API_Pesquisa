package com.gabrielMedeiros.API_Pesquisa.repository;

import com.gabrielMedeiros.API_Pesquisa.model.Operadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class OperadoraRepositoryTest {

    @Autowired
    OperadoraRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    @Transactional
    @DisplayName("Deve retornar operadoras quando apenas a UF é fornecida")
    void buscarComFiltroUf() {
        Operadora operadora = new Operadora(
                null, "00.000.000/0001-00", "Empresa PB",
                "Fantasia PB", "Cooperativa", "Rua A", "123",
                "", "Bairro", "Cidade", "PB",
                "58000-000", "83", "9999-9999", "9999-9998",
                "email@empresa.com", "Representante", "Cargo",
                1, LocalDate.of(2023, 1, 1)
        );
        em.persist(operadora);
        em.flush();

        List<Operadora> resultado = repository.buscarComFiltros(null, null, "PB");

        assertFalse(resultado.isEmpty());
        assertTrue(resultado.stream().allMatch(op -> "PB".equalsIgnoreCase(op.getUf())));
    }


    @Test
    @Transactional
    @DisplayName("Deve retornar operadoras quando termo e cidade forem informados")
    void buscarComTermoECidade() {
        Operadora operadora = new Operadora(
                null, "11.111.111/1111-11", "Nova Saúde Ltda",
                "Nova Saúde", "Medicina de Grupo", "Av. Central", "456",
                "", "Centro", "João Pessoa", "PB",
                "58001-000", "83", "3222-2222", "3222-2223",
                "saude@nova.com", "Maria", "Gerente",
                1, LocalDate.of(2022, 5, 1)
        );
        em.persist(operadora);
        em.flush();

        var resultado = repository.buscarComFiltros("%nova%", "João Pessoa", null);

        assertFalse(resultado.isEmpty(), "A lista de operadoras não deveria estar vazia");
        assertTrue(resultado.stream().anyMatch(op ->
                op.getNomeFantasia().toLowerCase().contains("nova") ||
                op.getRazaoSocial().toLowerCase().contains("nova")
        ));
    }


    @Test
    @Transactional
    @DisplayName("Deve retornar lista vazia quando nenhum filtro combinar")
    void buscarSemResultados() {
        List<Operadora> resultado = repository.buscarComFiltros("inexistente", "Cidade X", "ZZ");

        assertTrue(resultado.isEmpty());
    }


    @Test
    @Transactional
    @DisplayName("Deve retornar todos os registros quando nenhum filtro é passado")
    void buscarSemFiltros() {
        Operadora operadora1 = new Operadora(
                null, "22.222.222/2222-22", "Saúde Total",
                "Saúde Total", "Autogestão", "Rua B", "101",
                "", "Bairro C", "Recife", "PE",
                "50000-000", "81", "3456-7890", "3456-7891",
                "total@saude.com", "Ana", "Presidente",
                2, LocalDate.of(2021, 9, 1)
        );
        em.persist(operadora1);
        em.flush();

        var resultado = repository.buscarComFiltros(null, null, null);
        assertFalse(resultado.isEmpty());
    }
}

