package com.v2.artesa.Fragments;

import android.support.v4.app.Fragment;
import android.widget.ProgressBar;

import com.v2.artesa.Login.LoginPresenter;
import com.v2.artesa.Model.Person;

/**
 * Created by CaioSChristino on 09/01/17.
 */

public class mFragment extends Fragment {
    private LoginPresenter presenter;

    public mFragment(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    public LoginPresenter getPresenter() {
        return presenter;
    }

    public void updateProgressBar(ProgressBar progressBar){
        presenter.updateProgressBar(progressBar);
    }
}
