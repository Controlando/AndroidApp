package com.example.acer.controlandoandroid.model;

public class User {
    private String email, senha, token, nome;
    public User(String email, String senha, String token, String nome) {
        this.email = email;
        this.senha = senha;
        this.token = token;
        this.nome = nome;
    }

    public User(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "email: "+ getEmail() + '\n'+
                "senha: "+ getSenha() + '\n'+
                "nome: "+ getNome();
    }
}
