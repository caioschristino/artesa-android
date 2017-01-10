package com.v2.artesa.Login;

import android.content.Context;
import android.widget.ProgressBar;

import com.v2.artesa.Model.Person;
import com.v2.artesa.R;
import com.v2.artesa.Utils.AppStatus;

/**
 * Created by caios on 6/26/16.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private Context context;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView, Context context) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.context = context;
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void goToTermsFragment() {
        if (loginView != null) {
            Person person = loginView.getCurrentUser();
            if (person == null) {
                person = new Person();
            }

            loginView.setCurrentUser(person);
            loginView.navigateToTerms();
        }
    }

    @Override
    public void goToReviewFragment() {
        if (loginView != null) {
            Person person = loginView.getCurrentUser();
            if (person != null) {
                person.setAcceptTerms(true);
                loginView.setCurrentUser(person);
            }

            loginView.navigateToReview();
        }
    }

    @Override
    public void createAccount(Person person) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginView.setCurrentUser(person);
        loginInteractor.create(person, this);
    }

    @Override
    public void cacheAccount(Person person) {
        if (loginView != null) {
            loginView.setCurrentUser(person);
            loginView.hideProgress();
            loginView.navigateToTerms();
        }
    }

    @Override
    public Person getCacheAccount() {
        if (loginView != null) {
            return loginView.getCurrentUser();
        }
        return null;
    }

    @Override
    public void showMessage(String s) {
        if (loginView != null) {
            loginView.showMessage(s);
            loginView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onResume() {
        if (loginView != null) {
            loginView.showProgress();
        }

        if (!AppStatus.getInstance(this.context).isOnline()) {
            loginView.showMessage(this.context.getString(R.string.offiline));
            loginView.hideProgress();

            return;
        }

        loginInteractor.login(loginInteractor.loggedInFacebook(), this);
    }

    @Override
    public void updateProgressBar(ProgressBar progressBar) {
        if (loginView != null) {
            loginView.updateProgressComponent(progressBar);
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

    @Override
    public void onIgnoreSuccess() {
        if (loginView != null) {
            loginView.navigateToLogin();
        }
    }

    @Override
    public void onError(String s) {
        if (loginView != null) {
            loginView.showMessage(s);
            loginView.hideProgress();
        }
    }
}