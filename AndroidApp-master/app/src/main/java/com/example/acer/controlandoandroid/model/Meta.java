package com.example.acer.controlandoandroid.model;

public class Meta {
    private User user;
    private String nome, data, descricao, token;
    private float valor, juros;

    public Meta(User user, String nome, String data, String descricao, String token, float valor, float juros) {
        this.user = user;
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.token = token;
        this.valor = valor;
        this.juros = juros;
    }

    public Meta(String nome, String data, String descricao, float valor, float juros) {
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.juros = juros;
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

    public float getJuros() {
        return juros;
    }

    public void setJuros(float juros) {
        this.juros = juros;
    }

    public String toString(){
        return "Nome:"+getNome() + '\n'+
                "Descrição:"+getDescricao()+'\n'+
                "Data:"+getData() + '\n'+
                "Id do usuário"+user.getToken() + '\n'+
                "Valor da meta:"+getValor() + '\n'+
                "Juros:"+getJuros();
    }
}
