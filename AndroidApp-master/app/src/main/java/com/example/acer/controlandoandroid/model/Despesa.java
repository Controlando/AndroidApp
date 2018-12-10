package com.example.acer.controlandoandroid.model;

public class Despesa {
    private int nivel;
    private User user;
    private String nome;
    private String data, token;
    private String descricao;
    private String periodo;
    private float valor;

    public Despesa(User user, int nivel, String nome, String data, String token, String descricao, String periodo, float valor) {
        this.user = user;
        this.nivel = nivel;
        this.nome = nome;
        this.data = data;
        this.token = token;
        this.descricao = descricao;
        this.periodo = periodo;
        this.valor = valor;
    }
    public Despesa(int nivel, String nome, String data,String descricao, String periodo, float valor) {
        this.nivel = nivel;
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.periodo = periodo;
        this.valor = valor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String toString(){
        return "Nome:"+getNome() + '\n'+
                "Descrição:"+getDescricao()+'\n'+
                "Data:"+getData() + '\n'+
                "Nível:"+getNivel() + '\n'+
                "Id do usuário"+user.getToken() + '\n'+
                "Valor da despesa:"+getValor() + '\n'+
                "Periodo:"+getPeriodo();
    }
}
