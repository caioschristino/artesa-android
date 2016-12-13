package com.v2.artesa.Model;

/**
 * Created by CaioSChristino on 30/11/16.
 */

public class Response {
    private User user;

    public Response(){
        Status status = new Status("Ativo");
        Contact telefone = new Contact("(11) 97190-0161");
        Contact email = new Contact("caioschristino@gmail.com");

        this.user = new User("Caio Sanchez", email, "1234", telefone, "key_fac", "key_g", status);
    }

    public User getUser() {
        return user;
    }
}