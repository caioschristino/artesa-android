package com.v2.artesa.Login;

import com.v2.artesa.Model.Response;

/**
 * Created by caios on 6/26/16.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private String password;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        this.password = password;
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess(Response response) {
        if (loginView != null) {
            loginView.navigateToHome();
//            if (response.getUser().getSenha().equals(this.password)) {
//                loginView.navigateToHome();
//            } else {
//                onPasswordError();
//            }
        }
    }

    @Override
    public void onError(String s) {

    }
}