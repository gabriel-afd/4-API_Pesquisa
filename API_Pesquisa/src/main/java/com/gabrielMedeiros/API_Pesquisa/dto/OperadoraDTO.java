package com.gabrielMedeiros.API_Pesquisa.dto;

import com.gabrielMedeiros.API_Pesquisa.model.Operadora;



public class OperadoraDTO {

    private Integer registroAns;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String modalidade;
    private String cidade;
    private String uf;
    private String ddd;
    private String telefone;

    public OperadoraDTO(Operadora operadora){
        this.registroAns = operadora.getRegistroAns();
        this.cnpj = operadora.getCnpj();
        this.razaoSocial = operadora.getRazaoSocial();
        this.nomeFantasia = operadora.getNomeFantasia();
        this.modalidade = operadora.getModalidade();
        this.cidade = operadora.getCidade();
        this.uf = operadora.getUf();
        this.ddd = operadora.getDdd();
        this.telefone = operadora.getTelefone();
    }

    public Integer getRegistroAns() {
        return registroAns;
    }

    public void setRegistroAns(Integer registroAns) {
        this.registroAns = registroAns;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
