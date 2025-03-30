package com.gabrielMedeiros.API_Pesquisa.controller;

import com.gabrielMedeiros.API_Pesquisa.dto.OperadoraDTO;
import com.gabrielMedeiros.API_Pesquisa.model.Operadora;
import com.gabrielMedeiros.API_Pesquisa.service.OperadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operadoras")
public class OperadoraController {

    @Autowired
    private OperadoraService service;

    @GetMapping("/busca")
    public ResponseEntity<List<OperadoraDTO>> buscarOperadoras(
            @RequestParam(required = false) String termo,
            @RequestParam(required = false) String cidade,
            @RequestParam(required = false) String uf
    ){
        List<Operadora> operadoras = service.buscarComFiltros(termo, cidade, uf);

        List<OperadoraDTO> dtos = operadoras.stream()
                .map(OperadoraDTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }


}
