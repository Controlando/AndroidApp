package com.example.acer.controlandoandroid.model;

public class DespesaAux {
    String nome, descricao, dataDespesa;
    float valor;
    int id;

    public DespesaAux(String nome, String descricao, String dataDespesa, float valor, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDespesa = dataDespesa;
        this.valor = valor;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(String dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
