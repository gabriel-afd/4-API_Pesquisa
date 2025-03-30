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


    public List<Operadora> buscarComFiltros(String termo, String cidade, String uf) {
        if (termo != null && !termo.isBlank()) {
            termo = "%" + termo.trim().toLowerCase() + "%";
        } else {
            termo = null;
        }

        cidade = (cidade == null || cidade.isBlank()) ? null : cidade.trim();
        uf = (uf == null || uf.isBlank()) ? null : uf.trim();

        return repository.buscarComFiltros(termo, cidade, uf);
    }



}
