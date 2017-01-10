package com.v2.artesa.Fragments.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.v2.artesa.Fragments.mFragment;
import com.v2.artesa.Login.LoginPresenter;
import com.v2.artesa.R;
import com.v2.artesa.SessionManager;

/**
 * Created by CaioSChristino on 09/01/17.
 */

public class SplashFragment extends mFragment {
    private ProgressBar progressBar;

    public SplashFragment(LoginPresenter presenter) {
        super(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_splash, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress);
        updateProgressBar(progressBar);


        return rootView;
    }

    @Override
    public void onResume() {
        if (((SessionManager) getActivity().getApplicationContext()).load()) {
            ((SessionManager) getActivity().getApplicationContext()).setLoad(false);
            getPresenter().onResume();
        }

        super.onResume();
    }
}