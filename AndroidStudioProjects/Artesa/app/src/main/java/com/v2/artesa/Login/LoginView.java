package com.v2.artesa.Login;

import android.widget.ProgressBar;

import com.v2.artesa.Model.Person;

/**
 * Created by caios on 6/26/16.
 */
public interface LoginView {
    void showProgress();

    void hideProgress();

    void updateProgressComponent(ProgressBar progressBar);

    void navigateToHome();

    void navigateToTerms();

    void navigateToReview();

    void navigateToLogin();

    void showMessage(String s);

    void setCurrentUser(Person user);

    Person getCurrentUser();
}