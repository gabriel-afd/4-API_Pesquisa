package com.gabrielMedeiros.API_Pesquisa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "operadoras")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Operadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_ans")
    private Integer registroAns;

    private String cnpj;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    private String modalidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;
    private String fax;

    @Column(name = "endereco_eletronico")
    private String enderecoEletronico;

    private String representante;

    @Column(name = "cargo_representante")
    private String cargoRepresentante;

    @Column(name = "regiao_de_comercializacao")
    private Integer regiaoDeComercializacao;

    @Column(name = "data_registro_ans")
    private LocalDate dataRegistroAns;

    public Operadora() {
    }

    public Operadora(Integer registroAns, String cnpj, String razaoSocial, String nomeFantasia, String modalidade, String logradouro, String numero, String complemento, String bairro, String cidade, String uf, String cep, String ddd, String telefone, String fax, String enderecoEletronico, String representante, String cargoRepresentante, Integer regiaoDeComercializacao, LocalDate dataRegistroAns) {
        this.registroAns = registroAns;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.modalidade = modalidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.ddd = ddd;
        this.telefone = telefone;
        this.fax = fax;
        this.enderecoEletronico = enderecoEletronico;
        this.representante = representante;
        this.cargoRepresentante = cargoRepresentante;
        this.regiaoDeComercializacao = regiaoDeComercializacao;
        this.dataRegistroAns = dataRegistroAns;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEnderecoEletronico() {
        return enderecoEletronico;
    }

    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCargoRepresentante() {
        return cargoRepresentante;
    }

    public void setCargoRepresentante(String cargoRepresentante) {
        this.cargoRepresentante = cargoRepresentante;
    }

    public Integer getRegiaoDeComercializacao() {
        return regiaoDeComercializacao;
    }

    public void setRegiaoDeComercializacao(Integer regiaoDeComercializacao) {
        this.regiaoDeComercializacao = regiaoDeComercializacao;
    }

    public LocalDate getDataRegistroAns() {
        return dataRegistroAns;
    }

    public void setDataRegistroAns(LocalDate dataRegistroAns) {
        this.dataRegistroAns = dataRegistroAns;
    }
}
