package com.v2.artesa.Login;

/**
 * Created by caios on 6/26/16.
 */
public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}