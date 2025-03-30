package com.gabrielMedeiros.API_Pesquisa.repository;


import com.gabrielMedeiros.API_Pesquisa.model.Operadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperadoraRepository extends JpaRepository<Operadora, Integer> {


    @Query(value = """
    SELECT * FROM operadoras
    WHERE 
        (:termo IS NULL OR (
            LOWER(nome_fantasia) LIKE :termo OR
            LOWER(razao_social) LIKE :termo OR
            LOWER(modalidade) LIKE :termo OR
            LOWER(cidade) LIKE :termo OR
            cnpj LIKE :termo
        ))
        AND (:cidade IS NULL OR LOWER(cidade) = LOWER(:cidade))
        AND (:uf IS NULL OR LOWER(uf) = LOWER(:uf))
    """, nativeQuery = true)
    List<Operadora> buscarComFiltros(
            @Param("termo") String termo,
            @Param("cidade") String cidade,
            @Param("uf") String uf
    );






}
