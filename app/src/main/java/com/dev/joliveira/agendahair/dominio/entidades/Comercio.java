package com.dev.joliveira.agendahair.dominio.entidades;

import java.io.Serializable;

/**
 * Created by ADM on 31/01/2017.
 */

public class Comercio implements Serializable {

    public static  String TABELA = "COMERCIO";
    public static  String ID = "_id";
    public static  String NOME_COMERCIO = "NOME_COMERCIO";
    public static  String NOME_PROPRIETARIO = "NOME_PROPRIETARIO";
    public static  String RUA = "RUA";
    public static  String NUMERO = "NUMERO";
    public static  String BAIRRO = "BAIRRO";
    public static  String CIDADE = "CIDADE";
    public static  String ESTADO = "ESTADO";
    public static  String TELEFONE = "TELEFONE";
    public static  String CELULAR = "CELULAR";
    public static  String EMAIL = "EMAIL";

    private long id;
    private String nomeComercio;
    private String nomeProprietario;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String celular;
    private String email;

    public Comercio(){
        id = 0 ; //zerando o id

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeComercio() {
        return nomeComercio;
    }

    public void setNomeComercio(String nomeComercio) {
        this.nomeComercio = nomeComercio;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){ //retornar como String
        return nomeComercio + " " + rua;
    }
}