package com.v2.artesa.Login;

/**
 * Created by caios on 6/26/16.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}