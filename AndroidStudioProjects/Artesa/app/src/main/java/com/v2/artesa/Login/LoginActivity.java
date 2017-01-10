package com.v2.artesa.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.v2.artesa.Adapter.LoginPagerAdapter;
import com.v2.artesa.MainActivity;
import com.v2.artesa.Model.Person;
import com.v2.artesa.R;
import com.v2.artesa.SessionManager;

/**
 * Created by caios on 6/26/16.
 */
public class LoginActivity extends AppCompatActivity
        implements LoginView {
    private ProgressBar progressBar;
    private LoginPresenter presenter;
    private ViewPager viewPager;
    private LoginPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenterImpl(this, this);

        viewPager = (ViewPager) findViewById(R.id.myviewpager);
        mAdapter = new LoginPagerAdapter(getSupportFragmentManager(), presenter);
        viewPager.setAdapter(mAdapter);
    }

    @Override
    public void setCurrentUser(Person person) {
        ((SessionManager) getApplicationContext()).setPerson(person);
    }

    @Override
    public Person getCurrentUser() {
        return ((SessionManager) getApplicationContext()).getPerson();
    }


    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void navigateToTerms() {
        viewPager.setCurrentItem(2);
    }

    @Override
    public void navigateToReview() {
        viewPager.setCurrentItem(3);
    }

    @Override
    public void navigateToLogin() {
        viewPager.setCurrentItem(1);
    }

    @Override
    public void showMessage(String s) {
        Snackbar.make(viewPager, s, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void showProgress() {
        if (this.progressBar != null)
            this.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (this.progressBar != null)
            this.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void updateProgressComponent(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }
}