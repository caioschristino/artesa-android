package com.v2.artesa.Login;

import android.widget.ProgressBar;

import com.facebook.login.LoginResult;
import com.v2.artesa.Model.Person;

/**
 * Created by caios on 6/26/16.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void goToTermsFragment();

    void goToReviewFragment();

    void onDestroy();

    void onResume();

    void updateProgressBar(ProgressBar progressBar);

    void createAccount(Person person);

    void showMessage(String s);

    void cacheAccount(Person person);

    Person getCacheAccount();
}