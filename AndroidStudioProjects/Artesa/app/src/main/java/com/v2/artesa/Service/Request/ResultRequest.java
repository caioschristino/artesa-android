package com.v2.artesa.Service.Request;

import com.v2.artesa.Model.Person;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class ResultRequest {
    private String token;

    private Person person;

    public String getToken() {
        return token;
    }

    public Person getPerson() {
        return person;
    }
}
