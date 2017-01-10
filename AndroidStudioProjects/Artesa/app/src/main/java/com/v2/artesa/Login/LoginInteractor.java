package com.v2.artesa.Login;

import com.facebook.AccessToken;
import com.v2.artesa.Model.Person;

/**
 * Created by caios on 6/26/16.
 */
public interface LoginInteractor {

    AccessToken loggedInFacebook();

    interface OnLoginFinishedListener {
        void onSuccess();

        void onIgnoreSuccess();

        void onError(String s);
    }

    void login(String username, String password, final OnLoginFinishedListener listener);

    void login(AccessToken token, final OnLoginFinishedListener listener);

    void create(Person person, final OnLoginFinishedListener listener);
}