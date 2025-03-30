package com.gabrielMedeiros.API_Pesquisa.service;

import com.gabrielMedeiros.API_Pesquisa.model.Operadora;
import com.gabrielMedeiros.API_Pesquisa.repository.OperadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadoraService {

    @Autowired
    private OperadoraRepository repository;

    public List<Operadora> buscarPorTermo(String termo) {
        String like = "%" + termo.trim().toLowerCase() + "%";
        return repository.buscarPorTermo(like);
    }



}
