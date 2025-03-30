package com.gabrielMedeiros.API_Pesquisa.repository;


import com.gabrielMedeiros.API_Pesquisa.model.Operadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperadoraRepository extends JpaRepository<Operadora, Integer> {


    @Query(value = "SELECT * FROM operadoras WHERE " +
                   "LOWER(nome_fantasia) LIKE :termo OR " +
                   "LOWER(razao_social) LIKE :termo OR " +
                   "LOWER(modalidade) LIKE :termo OR " +
                   "LOWER(cidade) LIKE :termo OR " +
                   "cnpj LIKE :termo", nativeQuery = true)
    List<Operadora> buscarPorTermo(@Param("termo") String termo);






}
