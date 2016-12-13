package com.v2.artesa.Model;

/**
 * Created by CaioSChristino on 30/11/16.
 */

public class User {
    private String nome;
    private Contact email;
    private String senha;
    private Contact telefone;
    private String key_facebook;
    private String key_gmail;
    private Status status;

    public User() {
    }

    public User(String nome, Contact email, String senha,
                Contact telefone, String key_facebook, String key_gmail,
                Status status) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.key_facebook = key_facebook;
        this.key_gmail = key_gmail;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public Contact getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Contact getTelefone() {
        return telefone;
    }

    public String getKey_facebook() {
        return key_facebook;
    }

    public String getKey_gmail() {
        return key_gmail;
    }

    public Status getStatus() {
        return status;
    }
}
