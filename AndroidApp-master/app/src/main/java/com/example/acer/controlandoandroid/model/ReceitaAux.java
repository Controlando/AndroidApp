package com.example.acer.controlandoandroid.model;

public class ReceitaAux {
    String dataReceita;
    String nome, descricao;
    float valor;
    int id;
    public ReceitaAux(String nome, String dataReceita, float valor, int id) {
        this.dataReceita = dataReceita;
        this.nome = nome;
        this.valor = valor;
        this.id = id;
    }

    public ReceitaAux(String nome, String dataReceita, float valor, int id, String descricao) {
        this.dataReceita = dataReceita;
        this.nome = nome;
        this.valor = valor;
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(String dataReceita) {
        this.dataReceita = dataReceita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
