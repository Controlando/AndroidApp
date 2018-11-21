package com.example.acer.controlandoandroid.model;

public class Receita {
    private String nome, descricao, data, token;
    private User user;
    private float valor;

    public Receita(String nome, String descricao, String data, String token, User user, float valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.token = token;
        this.user = user;
        this.valor = valor;
    }

    public Receita(String nome, String descricao, String data, float valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                "Id do usuário"+user.getToken() + '\n'+
                "Valor da receita:"+getValor();
    }
}
