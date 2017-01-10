package com.v2.artesa.Model;

import android.text.TextUtils;

/**
 * Created by CaioSChristino on 30/11/16.
 */

public class Person {
    private String name;
    private String email;
    private String password;
    private boolean acceptTerms;
    private String gender;
    private String idIn;
    private String birthday;

    public Person() {
    }

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Person(String name, String email, String password, String gender) throws Exception {
        if (TextUtils.isEmpty(name)
                || TextUtils.isEmpty(email)
                || TextUtils.isEmpty(password)
                || TextUtils.isEmpty(gender)) {
            new Exception();
        }

        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public Person(String idIn, String name, String email, String password, String gender, String birthday) throws Exception {
        if (TextUtils.isEmpty(idIn)
                || TextUtils.isEmpty(idIn)
                || TextUtils.isEmpty(name)
                || TextUtils.isEmpty(email)
                || TextUtils.isEmpty(password)
                || TextUtils.isEmpty(gender)
                || TextUtils.isEmpty(birthday)) {
            new Exception();
        }

        this.idIn = idIn;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdIn() {
        return idIn;
    }

    public String getBirthday() {
        return birthday;
    }

    public boolean isAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }
}
